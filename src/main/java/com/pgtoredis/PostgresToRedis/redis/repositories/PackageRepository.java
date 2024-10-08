package com.pgtoredis.PostgresToRedis.redis.repositories;

import com.pgtoredis.PostgresToRedis.redis.model.Package;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends RedisDocumentRepository<Package,Integer> {
}
