package com.pgtoredis.PostgresToRedis.redis.repositories;

import com.pgtoredis.PostgresToRedis.redis.model.BusinessDevice;
import com.pgtoredis.PostgresToRedis.redis.model.DevicePackageExpireInfo;
import com.redis.om.spring.annotations.Query;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DevicePackageExpireInfoRepository extends RedisDocumentRepository<DevicePackageExpireInfo,Integer> {

    //"FT.SEARCH" "com.pgtoredis.PostgresToRedis.redis.model.DevicePackageExpireInfoIdx" "@businessDeviceBusinessDeviceId:[5087 5087] @isActive:{true}" "LIMIT" "0" "10000"
    @Query("@businessDeviceBusinessDeviceId:[$bId $businessId] @isActive:{true}")
    Optional<DevicePackageExpireInfo> findPackageInfoByBusinessDevice(Integer bId , Integer businessId);

}
