package com.pgtoredis.PostgresToRedis.redis.model;

import com.pgtoredis.PostgresToRedis.pg.model.PGBusinessDevice;
import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.NumericIndexed;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Document(value = "DevicePackageExpireInfo", timeToLive = 18120L)
public class DevicePackageExpireInfo {

    @Id @Indexed
    private Integer packageExpireId;
    @Indexed
    private long businessDeviceBusinessDeviceId;
    @Indexed
    //@Column(name = "create_time")
    private Timestamp createTime;
    @Indexed
    //@Column(name = "is_active")
    private Boolean isActive;
    @Indexed
    //@Column(name = "is_deleted")
    private Boolean isDeleted;
    @Indexed
    //@Column(name = "pacakge_start_time")
    private Timestamp packageStartTime;
    @Indexed
    //@Column(name = "package_expire_time")
    private Timestamp packageExpireTime;
    @Indexed
    // @Column(name = "package_name")
    private String packageName;
    @Indexed
    /*   @ManyToOne
       @JoinColumn(name = "packages_package_id", referencedColumnName = "package_id")*/
    private Integer packagesPackageId;
    @Indexed
    /*@ManyToOne
    @JoinColumn(name = "vendor_vendor_id", referencedColumnName = "vendor_id")*/
    private Integer vendorVendorId;

}
