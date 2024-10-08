package com.pgtoredis.PostgresToRedis.redis.controller;

import com.pgtoredis.PostgresToRedis.pg.model.PGDevice;
import com.pgtoredis.PostgresToRedis.pg.repositories.PGDeviceRepository;
import com.pgtoredis.PostgresToRedis.redis.model.Device;
import com.pgtoredis.PostgresToRedis.redis.repositories.DeviceRepository;
import com.pgtoredis.PostgresToRedis.redis.service.DeviceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("redis")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @GetMapping("load")
    public List<Device> pgToRedis() {
      return  deviceService.pgToRedis();
    }


}
