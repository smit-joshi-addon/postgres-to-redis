package com.pgtoredis.PostgresToRedis.pg.repositories;

import com.pgtoredis.PostgresToRedis.pg.model.PGVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PGVendorRepository extends JpaRepository<PGVendor,Integer> {
}
