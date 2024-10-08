package com.pgtoredis.PostgresToRedis.redis.model;

import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.NumericIndexed;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "of")
//@Document(timeToLive = 3600L)
public class Device {
    @Id
    @Indexed
    private Long deviceId;
    @Indexed
    private Integer vendorIdVendorId;
    @Indexed
    @Column(name = "created_by")
    private Integer createdBy;
    @NumericIndexed(sortable = true)
    @Column(name = "deleted_time")
    private Timestamp deletedTime;
    @Indexed
    @Column(name = "is_active")
    private boolean isActive;
    @Indexed
    @Column(name = "is_assign")
    private boolean isAssign;
    @Indexed
    @Column(name = "is_deleted")
    private boolean isDeleted;
    @Indexed
    @Column(name = "tracking_type")
    private Integer trackingType;
    @NumericIndexed(sortable = true)
    @Column(name = "created_time")
    private Timestamp createdTime;
    private Long brandModelIdBrandModelId;

    private Long deviceBrandIdDeviceBrandId;
    @Indexed
    private Integer deletedBy;
    @Indexed
    private String imei;
    @Indexed
    @Column(name = "status", length = 10)
    private String status;

    //private int businessPackageId;
    @Indexed
    @Column(name = "is_p2p_device")
    private boolean isP2PDevice;
    @NumericIndexed(sortable = true)
    @Column(name = "updated_time")
    private Timestamp updatedTime;

    @Column(name = "comment", length = 5000)
    private String comment;

}
