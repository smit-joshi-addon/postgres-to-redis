package com.pgtoredis.PostgresToRedis.redis.service;

import com.pgtoredis.PostgresToRedis.pg.model.PGBusiness;
import com.pgtoredis.PostgresToRedis.pg.model.PGDevice;
import com.pgtoredis.PostgresToRedis.pg.repositories.PGBusinessRepository;
import com.pgtoredis.PostgresToRedis.pg.repositories.PGDeviceRepository;
import com.pgtoredis.PostgresToRedis.redis.model.Business;
import com.pgtoredis.PostgresToRedis.redis.model.Device;
import com.pgtoredis.PostgresToRedis.redis.repositories.BusinessRepository;
import com.pgtoredis.PostgresToRedis.redis.repositories.DeviceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessService {
    @Autowired
    BusinessRepository businessRepository;

    @Autowired
    PGBusinessRepository pgBusinessRepository;

    //@Scheduled(fixedRate = 18000000) // Run every 1 hour (in milliseconds)
    public List<Business> pgToRedisBusiness() {
        List<Business> savedBusiness = null;
        try {
            businessRepository.deleteAll();
            System.out.println("Before");
            List<PGBusiness> postgresBusinesses = pgBusinessRepository.findAll();

            System.out.println("After");
            // Create a ModelMapper instance
            ModelMapper modelMapper = new ModelMapper();
            System.out.println("ModelMapper");

            List<Business> businesses = new ArrayList<>();
            postgresBusinesses.forEach(
                    pgBusiness -> {
                        Business business = modelMapper.map(pgBusiness, Business.class);
                        businesses.add(business);
                    }
            );

            // Check if devices is not empty before attempting to save
            if (!businesses.isEmpty()) {
                savedBusiness = businessRepository.saveAll(businesses);
                System.out.println("Record Updated: " + savedBusiness);
            } else {
                System.out.println("No devices to save.");
            }
            return savedBusiness;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

