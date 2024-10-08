package com.pgtoredis.PostgresToRedis.pg.repositories;

import com.pgtoredis.PostgresToRedis.pg.model.PGBusiness;
import com.pgtoredis.PostgresToRedis.pg.model.PGBusinessDevice;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PGBusinessDeviceRepository extends JpaRepository<PGBusinessDevice,Integer> {

    @Query("select bd from PGBusinessDevice bd where bd.isActive=true and bd.isDeleted=false")
    List<PGBusinessDevice> findAllActive();
}
