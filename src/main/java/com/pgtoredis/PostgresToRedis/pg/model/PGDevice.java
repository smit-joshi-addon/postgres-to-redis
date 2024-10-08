package com.pgtoredis.PostgresToRedis.pg.model;

import com.pgtoredis.PostgresToRedis.redis.model.Vendor;
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
@Table(name = "device",schema = "web")
public class PGDevice {
    @Id @Column(name = "device_id")
    private Long deviceId;

  /*  @ManyToOne
    @JoinColumn(name = "vendor_id_vendor_id")*/
    private Integer vendorIdVendorId;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "deleted_time")
    private Timestamp deletedTime;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_assign")
    private boolean isAssign;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "tracking_type")
    private Integer trackingType;

    @Column(name = "created_time")
    private Timestamp createdTime;

    private Long  brandModelIdBrandModelId;

    private Long deviceBrandIdDeviceBrandId;

    private Integer deletedBy;
    private String imei;

    @Column(name = "status", length = 10)
    private String status;

    //private int businessPackageId;

    @Column(name = "is_p2p_device")
    private boolean isP2PDevice;

    @Column(name = "updated_time")
    private Timestamp updatedTime;

    @Column(name = "comment", length = 5000)
    private String comment;

}
