package com.pgtoredis.PostgresToRedis.redis.service;

import com.pgtoredis.PostgresToRedis.pg.model.PGDevice;
import com.pgtoredis.PostgresToRedis.pg.repositories.PGDeviceRepository;
import com.pgtoredis.PostgresToRedis.redis.model.Device;
import com.pgtoredis.PostgresToRedis.redis.repositories.DeviceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    PGDeviceRepository pgDeviceRepository;

    //@Scheduled(fixedRate = 18000000) // Run every 1 hour (in milliseconds)
    public List<Device> pgToRedis() {
        List<Device> savedDevices = null;
        try {
            deviceRepository.deleteAll();
            System.out.println("Before");
            List<PGDevice> postgresDevices = pgDeviceRepository.findAll();

            System.out.println("After");
            // Create a ModelMapper instance
            ModelMapper modelMapper = new ModelMapper();
            System.out.println("ModelMapper");

            List<Device> devices = new ArrayList<>();
            postgresDevices.forEach(
                    pgDevice -> {
                        Device device = modelMapper.map(pgDevice, Device.class);
                        devices.add(device);
                    }
            );

            // Check if devices is not empty before attempting to save
            if (!devices.isEmpty()) {
                savedDevices = deviceRepository.saveAll(devices);
                System.out.println("Record Updated: " + savedDevices);
            } else {
                System.out.println("No devices to save.");
            }
            return savedDevices;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
