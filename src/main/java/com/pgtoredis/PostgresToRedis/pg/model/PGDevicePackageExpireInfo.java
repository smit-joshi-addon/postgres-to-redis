package com.pgtoredis.PostgresToRedis.pg.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "device_package_expire_info",schema = "web")
public class PGDevicePackageExpireInfo {
    @Id
    @Column(name = "package_expire_id")
    private Integer packageExpireId;

    /*@ManyToOne
    @JoinColumn(name = "business_device_business_device_id", referencedColumnName = "business_device_id")*/
    private Long businessDeviceBusinessDeviceId;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "pacakge_start_time")
    private Timestamp packageStartTime;

    @Column(name = "package_expire_time")
    private Timestamp packageExpireTime;

    @Column(name = "package_name")
    private String packageName;

 /*   @ManyToOne
    @JoinColumn(name = "packages_package_id", referencedColumnName = "package_id")*/
    private Integer packagesPackageId;

    /*@ManyToOne
    @JoinColumn(name = "vendor_vendor_id", referencedColumnName = "vendor_id")*/
    private Integer vendorVendorId;

}
