package com.pgtoredis.PostgresToRedis.redis.controller;

import com.pgtoredis.PostgresToRedis.redis.model.BusinessDevice;
import com.pgtoredis.PostgresToRedis.redis.repositories.BusinessDeviceRepository;
import com.pgtoredis.PostgresToRedis.redis.service.BusinessDeviceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.*;

import redis.clients.jedis.search.Document;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("businessDevice")
public class BusinessDeviceController {
    @Autowired
    BusinessDeviceService businessDeviceService;

    @Autowired
    BusinessDeviceRepository businessDeviceRepository;
    // private GeoOperations<String, String> geoOperations;

    @GetMapping("load")
    public List<BusinessDevice> pgToRedisBusinessDevice() {
        return businessDeviceService.pgToRedisBusinessDevice();
    }


    @GetMapping("businessDevice/{businessDeviceId}")
    public Optional<BusinessDevice> findByBusinessDeviceId(@PathVariable Long businessDeviceId) {
        return businessDeviceService.findByBusinessDeviceId(businessDeviceId);
    }

    @GetMapping("deviceToBusiness/{businessId}")
    public List<Long> findDeviceByBusinessId(@PathVariable Integer businessId) {
        return businessDeviceService.findDeviceByBusinessId(businessId);
    }

    // Get Only One Field
    @GetMapping("findDeviceByBusinessIdStream/{businessId}")
    public String findDeviceByBusinessIdStream(@PathVariable Integer businessId) {
        return businessDeviceService.findDeviceByBusinessIdStream(businessId);
    }

    //Not Working
    @GetMapping("deviceToBusinessList/{businessId}")
    public List<Document> findDeviceByBusinessIdList(@PathVariable Integer businessId) {
        return businessDeviceService.findDeviceByBusinessIdList(businessId);
    }

    @GetMapping("deviceToBusinessPackage/{businessId}")
    public List<Long> findDeviceByBusinessIdWithPackage(@PathVariable Integer businessId) {
        return businessDeviceService.findDeviceByBusinessIdWithPackage(businessId);
    }

    @GetMapping("near")
    public List<BusinessDevice> byLocationNear(@RequestParam("lat") double lat,
                                               @RequestParam("lon") double lon,
                                               @RequestParam("d") double distance) {
        return businessDeviceService.findByBusinessBusinessId_GpsLocationNear(lat, lon, distance);
    }

    //Return Counts
    @GetMapping("nearStaff")
    public String personNearStaff(@RequestParam("lat") double lat,
                                  @RequestParam("lon") double lon,
                                  @RequestParam("d") double distance) {
        return businessDeviceService.personNearStaff(lat, lon, distance);
    }

    //Return Ids
    @GetMapping("outsideStaff")
    public String personOutsideStaff(@RequestParam("lat") double lat,
                                     @RequestParam("lon") double lon,
                                     @RequestParam("d") double distance) {
        return businessDeviceService.personOutsideStaff(lat, lon, distance);
    }

    @GetMapping("group")
    public List<Map<String, Object>> groupByBusinessId() {
        var pairs = businessDeviceRepository.groupByBusinessId();
        System.out.println("Pair" + pairs);
        System.out.println("Rows:" + pairs.toString());
        List<Map<String, Object>> results = pairs.getResults();
        System.out.println("Results" + results);
        return results;
    }

    @GetMapping("busDevCount")
    public List<Map<String, Object>> DistinctBusinessId() {
        var pairs = businessDeviceRepository.distinctBusinessId();
        System.out.println("Pair" + pairs.getTotalResults());
        System.out.println("Rows:" + pairs.getRows());
        List<Map<String, Object>> results = pairs.getResults();
        System.out.println("Results" + results);
        return results;
    }

    @GetMapping("activeBusDev")
    public List<Map<String, Object>> activeBusDev() {
        var pairs = businessDeviceRepository.activeBusinessDeviceList();
        System.out.println("Pair" + pairs.getTotalResults());
        System.out.println("Rows:" + pairs.getRows());
        List<Map<String, Object>> results = pairs.getResults();
        System.out.println("Results" + results);
        return results;
    }

    @GetMapping("activeBusDevMobNum")
    public List<Map<String, Object>> activeBusDevMobNum() {
        var pairs = businessDeviceRepository.activeBusinessDeviceWithNumberList();
        System.out.println("Pair" + pairs.getTotalResults());
        System.out.println("Rows:" + pairs.getRows());
        List<Map<String, Object>> results = pairs.getResults();
        System.out.println("Results" + results);
        return results;
    }

    @GetMapping("findDistanceDurationTenMinutes")
    public List<Map<String, Object>> findDistanceDurationTenMinutes() {
        return businessDeviceService.findDistanceDurationTenMinutes();
    }

    @GetMapping("geoLocationDistance")
    public List<Map<String, Object>> geoLocationDistance() {
        Point point1 = null;
        Point point2 = null;

        var pairs = businessDeviceRepository.geoLocationDistance();
        System.out.println("Pair" + pairs.getTotalResults());
        System.out.println("Rows:" + pairs.getRows());
        List<Map<String, Object>> results = pairs.getResults();
        System.out.println("Results" + results);
        return results;
    }

    // Only return first 10 Documents
    @GetMapping("businessDevList")
    public String BusinessDeviceIdsList() {
        var pairs = businessDeviceRepository.businessDeviceIdList();
        System.out.println("Pair" + pairs.getTotalResults());
        System.out.println("Rows:" + pairs.getRows());
        List<Map<String, Object>> results = pairs.getResults();
        System.out.println("Results" + results);
        return results.toString();
    }
}
