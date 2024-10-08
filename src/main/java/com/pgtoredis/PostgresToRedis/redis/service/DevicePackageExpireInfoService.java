package com.pgtoredis.PostgresToRedis.redis.service;

import com.pgtoredis.PostgresToRedis.pg.model.PGDevicePackageExpireInfo;
import com.pgtoredis.PostgresToRedis.pg.repositories.PGDevicePackageExpireInfoRepository;
import com.pgtoredis.PostgresToRedis.redis.model.DevicePackageExpireInfo;
import com.pgtoredis.PostgresToRedis.redis.repositories.DevicePackageExpireInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DevicePackageExpireInfoService {
    @Autowired
    DevicePackageExpireInfoRepository devicePackageExpireInfoRepository;
    @Autowired
    PGDevicePackageExpireInfoRepository pgDevicePackageExpireInfoRepository;

    //@Scheduled(fixedRate = 18000000) // Run every 1 hour (in milliseconds)
    public List<DevicePackageExpireInfo> pgToRedisDevicePackageExpireInfo() {
        List<DevicePackageExpireInfo> savedDevicePackageExpireInfo = null;
        try {
            //businessDeviceRepository.deleteAll();
            System.out.println("Before");
            List<PGDevicePackageExpireInfo> postgresPackageExpireInfo = pgDevicePackageExpireInfoRepository.findAllActive();

            System.out.println("After");
            // Create a ModelMapper instance
            ModelMapper modelMapper = new ModelMapper();
            List<DevicePackageExpireInfo> packageExpireInfoList = new ArrayList<>();
            postgresPackageExpireInfo.forEach(
                    pgPackageExpireInfo -> {
                        DevicePackageExpireInfo devicePackageExpireInfo = modelMapper.map(pgPackageExpireInfo, DevicePackageExpireInfo.class);
                        packageExpireInfoList.add(devicePackageExpireInfo);
                    }
            );

            // Check if devices is not empty before attempting to save
            if (!packageExpireInfoList.isEmpty()) {
                savedDevicePackageExpireInfo = devicePackageExpireInfoRepository.saveAll(packageExpireInfoList);
                System.out.println("Record Updated: " + savedDevicePackageExpireInfo);
            } else {
                System.out.println("No Package Device Info to save.");
            }
            return savedDevicePackageExpireInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<DevicePackageExpireInfo> findPackageInfoByBusinessDevice(Integer businessId) {
        Integer bId = businessId;
        return devicePackageExpireInfoRepository.findPackageInfoByBusinessDevice(bId,businessId);
    }
}
