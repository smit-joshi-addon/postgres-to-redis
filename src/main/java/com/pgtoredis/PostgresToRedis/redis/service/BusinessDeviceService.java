package com.pgtoredis.PostgresToRedis.redis.service;

import com.pgtoredis.PostgresToRedis.pg.model.PGBusinessDevice;
import com.pgtoredis.PostgresToRedis.pg.repositories.PGBusinessDeviceRepository;
import com.pgtoredis.PostgresToRedis.redis.model.BusinessDevice;
import com.pgtoredis.PostgresToRedis.redis.model.BusinessDevice$;
import com.pgtoredis.PostgresToRedis.redis.repositories.BusinessDeviceRepository;
import com.redis.om.spring.search.stream.EntityStream;
import org.locationtech.jts.geom.Geometry;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import redis.clients.jedis.search.Document;
import redis.clients.jedis.search.SearchResult;
import redis.clients.jedis.search.aggr.AggregationResult;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BusinessDeviceService {
    @Autowired
    BusinessDeviceRepository businessDeviceRepository;

    @Autowired
    PGBusinessDeviceRepository pgBusinessDeviceRepository;

    @Autowired
    EntityStream entityStream;

    //private final Pipeline pipeline = null;


    //@Scheduled(fixedRate = 18000000) // Run every 1 hour (in milliseconds) 5hr
    public List<BusinessDevice> pgToRedisBusinessDevice() {
        List<BusinessDevice> savedBusinessDevices = null;
        try {

            //businessDeviceRepository.deleteAll();
            System.out.println("Before");
            Page<PGBusinessDevice> postgresBusinessDevices = pgBusinessDeviceRepository.findAll(PageRequest.of(0, 20));

            System.out.println("After");
            // Create a ModelMapper instance
            ModelMapper modelMapper = new ModelMapper();
            // Add the custom converter for Geometry to Point

            System.out.println("ModelMapper");
            List<BusinessDevice> businessDevices = new ArrayList<>();
            postgresBusinessDevices.forEach(
                    pgBusinessDevice -> {
                        BusinessDevice businessDevice = modelMapper.map(pgBusinessDevice, BusinessDevice.class);
                        // Manual conversion from Geometry to Point
                        Geometry geometry = pgBusinessDevice.getBusinessBusinessId().getGpsLocation();
                        Point point = new Point(geometry.getCoordinate().getX(), geometry.getCoordinate().getY());

                        // Set the converted Point to the BusinessDevice
                        businessDevice.getBusinessBusinessId().setGpsLocation(point);
                        businessDevices.add(businessDevice);
                    }
            );

            // Check if devices is not empty before attempting to save
            if (!businessDevices.isEmpty()) {
                savedBusinessDevices = businessDeviceRepository.saveAll(businessDevices);
                System.out.println("Record Updated: " + savedBusinessDevices);
            } else {
                System.out.println("No devices to save.");
            }
            return savedBusinessDevices;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Long> findDeviceByBusinessId(Integer businessId) {
        Integer bId = businessId;
        List<BusinessDevice> businessDevices = businessDeviceRepository.findDeviceByBusinessId(businessId, bId);

        // Collecting businessDeviceIds into a List<Long>
        List<Long> businessDeviceIds = businessDevices.stream()
                .map(BusinessDevice::getBusinessDeviceId)
                .collect(Collectors.toList());
        System.out.println("businessDeviceIds" + businessDeviceIds);
        return businessDeviceIds;
    }

    public List<Document> findDeviceByBusinessIdList(Integer businessId) {
        Integer bId = businessId;
        //List<Map<String, Object>> businessDevices = businessDeviceRepository.findDeviceByBusinessIdMap(businessId, bId);
        SearchResult businessDevices = businessDeviceRepository.findDeviceByBusinessIdList(businessId, bId);
        System.out.println("..." + businessDevices.getClass());
        System.out.println("businessDevices" + businessDevices.getDocuments());
        System.out.println("businessDevices" + businessDevices.getTotalResults());
        System.out.println("businessDevices String" + businessDevices.toString());
        return businessDevices.getDocuments();
    }

    public String findDeviceByBusinessIdStream(Integer businessId) {
        Integer bId = businessId;
        //This only return the map field
        List<Long> ids =
                entityStream //
                        .of(BusinessDevice.class)
                        .filter(BusinessDevice$.BUSINESS_BUSINESS_ID_BUSINESS_ID.eq(businessId))
                        .map(BusinessDevice$.BUSINESS_DEVICE_ID)
                        .collect(Collectors.toList());

        System.out.println("Business Device Ids" + ids);

        long tenMinutesInMillis = 10 * 60 * 1000; // 10 minutes in milliseconds
        long tenMinutesAgoInMillis = System.currentTimeMillis() - tenMinutesInMillis;
        String tenMinutesAgoCondPrev = String.format("@deviceDeviceId_deletedTime:[%d +inf]", tenMinutesAgoInMillis);
        String tenMinutesAgoCondCurrent = String.format("@deviceDeviceId_deletedTime:[%d +inf]", tenMinutesAgoInMillis);

        List<Point> collect = entityStream.of(BusinessDevice.class)
                .filter(tenMinutesAgoCondPrev)
                .map(BusinessDevice$.BUSINESS_BUSINESS_ID_GPS_LOCATION)// Assuming getGpsLocation returns the Point field
                .collect(Collectors.toList());


        return ids.toString();
    }

    // Find the distance of current & 10 minutes before
    public List<Map<String, Object>> findDistanceDurationTenMinutes() {
        long tenMinutesInMillis = 10 * 60 * 1000; // 10 minutes in milliseconds
        long tenMinutesAgoInMillis = System.currentTimeMillis() - tenMinutesInMillis;
        String tenMinutesAgoCondPrev = String.format("@deviceDeviceId_deletedTime:[%d +inf]", tenMinutesAgoInMillis);

        List<Point> collect =
                entityStream.of(BusinessDevice.class)
                        .filter(tenMinutesAgoCondPrev)
                        .map(BusinessDevice$.BUSINESS_BUSINESS_ID_GPS_LOCATION)// Assuming getGpsLocation returns the Point field

                        .collect(Collectors.toList());

        //NOT WORK  .sorted(Sort.Order.asc("@deviceDeviceId_deletedTime"))
        AggregationResult result = null;

        // Iterate over the list of collected points and calculate distances
        for (int i = 0; i < collect.size() - 1; i++) {
            Point point1 = collect.get(i);
            Point point2 = collect.get(i + 1);


            // Call the repository method geoLocationDistance for each pair of points
            result = businessDeviceRepository.geoPersonDistance(point1, point2);

            System.out.println("Result" + result.getResults());

            // Assuming results contains a single entry with the distance
            double distance = (double) result.getResults().get(0).get("distance");
            System.out.println("Distance" + distance);
            //distances.add(distance);
        }

        return result.getResults();
    }

    // Client Workers Monitoring
    public String personNearStaff(double lat, double lon, double distance) {
        Point point = new Point(lon, lat);
        Distance distanceKm = new Distance(distance, Metrics.KILOMETERS);
        long count = entityStream
                .of(BusinessDevice.class)
                .filter(BusinessDevice$.BUSINESS_BUSINESS_ID_GPS_LOCATION.near(point, distanceKm))
                .count();
        System.out.println("Count " + count);
        return "The Pearson that are near is " + String.valueOf(count);
    }

    //Give the premise and find which staff is not in the premise
    public String personOutsideStaff(double lat, double lon, double distance) {
        Point point = new Point(lon, lat);
        Distance distanceKm = new Distance(distance, Metrics.KILOMETERS);
        List<Long> count = entityStream
                .of(BusinessDevice.class)
                .filter(BusinessDevice$.BUSINESS_BUSINESS_ID_GPS_LOCATION.outsideOf(point, distanceKm))
                .map(BusinessDevice$.BUSINESS_DEVICE_ID)
                .collect(Collectors.toList());
        // .count();
        System.out.println("Count " + count);
        return "The Pearson that are Outside / Not in the Premises are is " + String.valueOf(count);
    }


    public List<Long> findDeviceByBusinessIdWithPackage(Integer businessId) {
        Integer bId = businessId;
        List<BusinessDevice> businessDevices = businessDeviceRepository.findDeviceByBusinessId(businessId, bId);
        //pipeline.ftSearch("com.pgtoredis.PostgresToRedis.redis.model.BusinessDeviceIdx","@businessBusinessId_businessId:[$businessId $bId]");
        //pipeline.sync();
        // Collecting businessDeviceIds into a List<Long>
        List<Long> businessDeviceIds = businessDevices.stream()
                .map(BusinessDevice::getBusinessDeviceId)
                .collect(Collectors.toList());
        System.out.println("businessDeviceIds" + businessDeviceIds);

        return businessDeviceIds;
    }

    public Optional<BusinessDevice> findByBusinessDeviceId(Long businessDeviceId) {
        Long bdId = businessDeviceId;
        Optional<BusinessDevice> businessDevices = businessDeviceRepository.findByBusinessDeviceId(businessDeviceId, bdId);
        System.out.println("Business Device Id" + businessDevices);
        return businessDevices;
    }

    public List<BusinessDevice> findByBusinessBusinessId_GpsLocationNear(double lat, double lon, double distance) {
        Point point = new Point(lon, lat);
        Distance distanceKm = new Distance(distance, Metrics.KILOMETERS);
        List<BusinessDevice> businessDevices = businessDeviceRepository.findByBusinessBusinessId_GpsLocationNear(point, distanceKm);
        System.out.println("businessDevices" + businessDevices);
        return businessDevices;
    }


}
