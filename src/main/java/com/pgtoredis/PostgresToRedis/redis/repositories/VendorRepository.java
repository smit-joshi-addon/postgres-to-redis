package com.pgtoredis.PostgresToRedis.redis.repositories;

import com.pgtoredis.PostgresToRedis.redis.model.Vendor;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends RedisDocumentRepository<Vendor,Integer> {
}
