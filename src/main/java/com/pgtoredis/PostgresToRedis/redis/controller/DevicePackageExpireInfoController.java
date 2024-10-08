package com.pgtoredis.PostgresToRedis.redis.controller;


import com.pgtoredis.PostgresToRedis.redis.model.DevicePackageExpireInfo;
import com.pgtoredis.PostgresToRedis.redis.service.DevicePackageExpireInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("devicePackageExpireInfo")
public class DevicePackageExpireInfoController {

    @Autowired
    DevicePackageExpireInfoService devicePackageExpireInfoService;

    @GetMapping("load")
    public List<DevicePackageExpireInfo> pgToRedisDevicePackageExpireInfo() {
        return devicePackageExpireInfoService.pgToRedisDevicePackageExpireInfo();
    }
    @GetMapping("package")
    public Optional<DevicePackageExpireInfo> findPackageInfoByBusinessDevice(@RequestParam Integer businessId) {
        return devicePackageExpireInfoService.findPackageInfoByBusinessDevice(businessId);
    }

}
