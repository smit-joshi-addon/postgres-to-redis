package com.pgtoredis.PostgresToRedis.pg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
@Entity
@Table(name = "business_device",schema = "web")
public class PGBusinessDevice {
    @Id  @Column(name = "business_device_id")
    private Long businessDeviceId;
    @ManyToOne
    @JoinColumn(name = "business_business_id")
    private PGBusiness businessBusinessId;
    @ManyToOne
    @JoinColumn(name = "device_device_id")
    private PGDevice deviceDeviceId;
    @ManyToOne
    @JoinColumn(name = "vendor_vendor_id")
    private PGDevice vendorVendorId;
    @ManyToOne
    @JoinColumn(name = "packages_package_id")
    private PGPackage packagesPackageId;

    private String address;
    private Long businessIdBusinessId;

    private Integer businessBranchBusinessBranchId;

    private Integer businessPackageId;

    private int createdBy;

    private Long createdByUserId;

    private Timestamp createdTime;
    private Timestamp deletedTime;

    private String deviceAlias;
    private Long device_id_device_id;
    private Integer driverId;

    private boolean isAcOff;
    private boolean isAcOn;
    private boolean isActive;
    private boolean isDeleted;

    private Boolean isFallDown;

    private Boolean isFranchiseEnter;

    private Boolean isFranchiseExit;

    private Boolean isFuelSupported;

    private boolean isGeofenceEnter;

    private boolean isGeofenceExit;

    private boolean isHardAcceleration;

    private boolean isHardBrake;

    private boolean isIgnitionOff;

    private boolean isIgnitionOn;

    private Boolean isImmobilizer;

    private Boolean isTemperatureSupported;

    private Boolean isLowBattery;

    private Boolean isOverSpeed;

    private boolean isPowerCutt;

    private boolean isPowerOn;

    private Boolean isRampOff;

    private Boolean isRampOn;

    private Boolean isSos;

    private Integer lastObservationId;

    private Integer liveobLiveObId;

    private Integer p2pUserId;

    private Integer positionId;

    private Integer simcardId;

    private Integer simcardSimcardId;

    private String observationUuid;

    private String selectedAlertType;

    private String selectedFeature;

    private Integer vehicleimageidVehicleimageid;

    private String vehicleimagename;

    private Double todometer;

    private Double vodometer;

}
