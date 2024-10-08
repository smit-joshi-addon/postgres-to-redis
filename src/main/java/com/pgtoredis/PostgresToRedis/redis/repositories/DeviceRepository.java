package com.pgtoredis.PostgresToRedis.redis.repositories;

import com.pgtoredis.PostgresToRedis.redis.model.Device;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends RedisDocumentRepository<Device,Long> {
}
