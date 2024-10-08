package com.pgtoredis.PostgresToRedis.pg.controller;

import com.pgtoredis.PostgresToRedis.pg.model.PGBusinessDevice;
import com.pgtoredis.PostgresToRedis.pg.model.PGDevicePackageExpireInfo;
import com.pgtoredis.PostgresToRedis.pg.repositories.PGDevicePackageExpireInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pgDevicePackageExpireInfo")
public class PGDevicePackageExpireInfoController {

    @Autowired
    PGDevicePackageExpireInfoRepository pgDevicePackageExpireInfoRepository;

    @GetMapping("get")
    public List<PGDevicePackageExpireInfo> getAll(){
        //System.out.println("Hello Business...\n"+pgBusinessDeviceRepository.findAll());
        return pgDevicePackageExpireInfoRepository.findAll();
    }
}
