package com.pgtoredis.PostgresToRedis.pg.repositories;

import com.pgtoredis.PostgresToRedis.pg.model.PGDevicePackageExpireInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PGDevicePackageExpireInfoRepository extends JpaRepository<PGDevicePackageExpireInfo,Integer> {

   @Query("Select p from PGDevicePackageExpireInfo p where p.isActive = true")
    List<PGDevicePackageExpireInfo> findAllActive();
}
