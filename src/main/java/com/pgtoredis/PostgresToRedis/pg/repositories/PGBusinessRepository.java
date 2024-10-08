package com.pgtoredis.PostgresToRedis.pg.repositories;

import com.pgtoredis.PostgresToRedis.pg.model.PGBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PGBusinessRepository extends JpaRepository<PGBusiness,Integer> {
}
