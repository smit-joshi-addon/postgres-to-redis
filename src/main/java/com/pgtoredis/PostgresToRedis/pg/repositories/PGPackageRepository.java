package com.pgtoredis.PostgresToRedis.pg.repositories;

import com.pgtoredis.PostgresToRedis.pg.model.PGPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PGPackageRepository extends JpaRepository<PGPackage,Long> {
}
