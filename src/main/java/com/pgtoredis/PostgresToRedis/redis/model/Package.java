package com.pgtoredis.PostgresToRedis.redis.model;


import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.NumericIndexed;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "of")
//@Document(timeToLive = 3600)
public class Package {
    @Id
    @Indexed
    private Long packageId;

    @Indexed
   /* @ManyToOne
    @JoinColumn(name = "vendor_vendor_id")*/
    private Integer vendorVendorId;
    @NumericIndexed
    //    @Column(name = "active_time")
    private Timestamp activeTime;
    @Indexed
    //    @Column(name = "created_by")
    private int createdBy;
    @NumericIndexed
    //    @Column(name = "created_time")
    private Timestamp createdTime;
    @NumericIndexed
    //    @Column(name = "deactive_time")
    private Timestamp deactiveTime;

    //    @Column(name = "deleted_by")
    // private Integer deletedBy;
    @NumericIndexed
    //    @Column(name = "deleted_time")
    private Timestamp deletedTime;
    @Indexed
    //    @Column(name = "feature")
    private String feature;
    @Indexed
    //    @Column(name = "is_active")
    private boolean isActive;
    @Indexed
    @Column(name = "is_attendance_for_p2p")
    private boolean isAttendanceForP2p;
    @Indexed
    //    @Column(name = "is_booking")
    private boolean isBooking;
    @Indexed
    //    @Column(name = "is_deleted")
    private boolean isDeleted;
    @Indexed
    //    @Column(name = "is_driver")
    private boolean isDriver;
    @Indexed
    //    @Column(name = "is_fms")
    private boolean isFms;
    @Indexed
    //    @Column(name = "is_franchise")
    private boolean isFranchise;
    @Indexed
    //    @Column(name = "is_route_available")
    private boolean isRouteAvailable;
    @Indexed
    //    @Column(name = "is_route_with_parent_app")
    private boolean isRouteWithParentApp;
    @Indexed
    //    @Column(name = "is_share_history")
    private boolean isShareHistory;
    @Indexed
    //    @Column(name = "is_tour")
    private boolean isTour;
    @Indexed
    //    @Column(name = "monthly_price")
    private Double monthlyPrice;
    @Indexed
    //    @Column(name = "package_name")
    private String packageName;
    @Indexed
    //    @Column(name = "package_type")
    private String packageType;

    //    @Column(name = "page_name")
//    private String pageName;
    @Indexed
    //    @Column(name = "setup_fees")
    private Double setupFees;
    @Indexed
    //    @Column(name = "yearly_price")
    private Double yearlyPrice;
}
