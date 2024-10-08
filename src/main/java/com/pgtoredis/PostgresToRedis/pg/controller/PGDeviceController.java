package com.pgtoredis.PostgresToRedis.pg.controller;


import com.pgtoredis.PostgresToRedis.pg.model.PGDevice;
import com.pgtoredis.PostgresToRedis.pg.repositories.PGDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pgDevice")
public class PGDeviceController {
    @Autowired
    PGDeviceRepository pgDeviceRepository;
    @GetMapping("get")
    public List<PGDevice> getAll(){

        System.out.println("Hello"+pgDeviceRepository.findAll());
        return null;
    }
}
