package com.pgtoredis.PostgresToRedis.redis.controller;

import com.pgtoredis.PostgresToRedis.redis.model.Business;
import com.pgtoredis.PostgresToRedis.redis.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("redisBusiness")
public class BusinessController {
    @Autowired
    BusinessService businessService;

    @GetMapping("load")
    public List<Business> pgToRedisBusiness() {
        return businessService.pgToRedisBusiness();
    }

    @GetMapping("test")
    public List<Long> test() {
        List<Long> aa = Arrays.asList(100000L, 200000L);
        return aa;
    }

}
