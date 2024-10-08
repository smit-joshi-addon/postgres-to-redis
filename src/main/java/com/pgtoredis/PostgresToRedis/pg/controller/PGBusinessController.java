package com.pgtoredis.PostgresToRedis.pg.controller;

import com.pgtoredis.PostgresToRedis.pg.model.PGBusiness;
import com.pgtoredis.PostgresToRedis.pg.model.PGDevice;
import com.pgtoredis.PostgresToRedis.pg.repositories.PGBusinessRepository;
import org.locationtech.jts.shape.random.RandomPointsInGridBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pgBusiness")
public class PGBusinessController {
    @Autowired
    PGBusinessRepository pgBusinessRepository;

    @GetMapping("get")
    public List<PGBusiness> getAll(){
        System.out.println("Hello Business...\n"+pgBusinessRepository.findAll());

        List<PGBusiness> pgBusinesses=pgBusinessRepository.findAll();

        for(PGBusiness pgBusiness:pgBusinesses)
        {
            System.out.println("\n \t  business_name===="+pgBusiness.getBusinessName());
            System.out.println("\n \t  gps_location===="+pgBusiness.getGpsLocation().toText());
        }

        System.out.println("gps_location");
        return pgBusinessRepository.findAll();
    }

}
