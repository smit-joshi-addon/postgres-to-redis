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
@Table(name = "package",schema = "web")
public class PGPackage {
    @Id
    private Long packageId;

   /* @ManyToOne
    @JoinColumn(name = "vendor_vendor_id")*/
    private Integer vendorVendorId;

//    @Column(name = "active_time")
    private Timestamp activeTime;

//    @Column(name = "created_by")
    private int createdBy;

//    @Column(name = "created_time")
    private Timestamp createdTime;

//    @Column(name = "deactive_time")
    private Timestamp deactiveTime;

//    @Column(name = "deleted_by")
   // private Integer deletedBy;

//    @Column(name = "deleted_time")
    private Timestamp deletedTime;

//    @Column(name = "feature")
    private String feature;

//    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_attendance_for_p2p")
    private boolean isAttendanceForP2p;

//    @Column(name = "is_booking")
    private boolean isBooking;

//    @Column(name = "is_deleted")
    private boolean isDeleted;

//    @Column(name = "is_driver")
    private boolean isDriver;

//    @Column(name = "is_fms")
    private boolean isFms;

//    @Column(name = "is_franchise")
    private boolean isFranchise;

//    @Column(name = "is_route_available")
    private boolean isRouteAvailable;

//    @Column(name = "is_route_with_parent_app")
    private boolean isRouteWithParentApp;

//    @Column(name = "is_share_history")
    private boolean isShareHistory;

//    @Column(name = "is_tour")
    private boolean isTour;

//    @Column(name = "monthly_price")
    private Double monthlyPrice;

//    @Column(name = "package_name")
    private String packageName;

//    @Column(name = "package_type")
    private String packageType;

//    @Column(name = "page_name")
//    private String pageName;

//    @Column(name = "setup_fees")
    private Double setupFees;

//    @Column(name = "yearly_price")
    private Double yearlyPrice;
}
