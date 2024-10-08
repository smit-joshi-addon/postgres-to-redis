package com.pgtoredis.PostgresToRedis.redis.repositories;

import com.pgtoredis.PostgresToRedis.redis.model.Business;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends RedisDocumentRepository<Business,Integer> {
}
