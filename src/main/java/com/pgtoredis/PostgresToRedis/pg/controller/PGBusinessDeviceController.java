package com.pgtoredis.PostgresToRedis.pg.controller;

import com.pgtoredis.PostgresToRedis.pg.model.PGBusiness;
import com.pgtoredis.PostgresToRedis.pg.model.PGBusinessDevice;
import com.pgtoredis.PostgresToRedis.pg.model.PGPackage;
import com.pgtoredis.PostgresToRedis.pg.model.PGVendor;
import com.pgtoredis.PostgresToRedis.pg.repositories.PGBusinessDeviceRepository;
import com.pgtoredis.PostgresToRedis.pg.repositories.PGPackageRepository;
import com.pgtoredis.PostgresToRedis.pg.repositories.PGVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pgBusinessDevice")
public class PGBusinessDeviceController {
    @Autowired
    PGBusinessDeviceRepository pgBusinessDeviceRepository;

    @Autowired
    PGPackageRepository pgPackageRepository;
    @Autowired
    PGVendorRepository pgVendorRepository;


    @GetMapping("get")
    public List<PGBusinessDevice> getAll(){
        //System.out.println("Hello Business...\n"+pgBusinessDeviceRepository.findAll());
        return pgBusinessDeviceRepository.findAll();
    }

    @GetMapping("getV")
    public List<PGVendor> getAllV(){
        System.out.println("Hello Ven...\n"+pgVendorRepository.findAll());
        return null;
    }

    @GetMapping("getP")
    public List<PGPackage> getAllP(){
        System.out.println("Hello Package...\n"+pgPackageRepository.findAll());
        return null;
    }
}
