package com.pgtoredis.PostgresToRedis.pg.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Geometry;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
@Entity
@Table(name = "business",schema = "web")
public class PGBusiness {
    @Id @Column(name="business_id")
    private Integer businessId;

    private Integer vendorVendorId;

    private String businessprofileImagePath;
    private String address;
    private String businessName;
    private Integer countryId;
    private Integer createdBy;
    private Timestamp createdTime;
    private Integer defaultLandingPage;
    private Integer defaultMap;
    private Integer deletedBy;
    private Timestamp deletedTime;
    private Integer firstDayOfWeek;
    private String googleMapKey;
    @Column(columnDefinition = "geometry")
    private Geometry gpsLocation;
    private boolean isActive;
    private boolean isDeleted;
    private Integer language;
    private Integer mapView;
    private Integer menuView;
    private String mobileNumber;
    private Integer speedUnit;
    private Integer timezoneId;
    private String zipcode;
    private Integer vendorId;
    private Integer preferredLanguage;
    private Boolean emailnotification;

    private Boolean isMail;
    private Boolean isSms;
    private Boolean kycRequest;
    private Timestamp kycRequestTime;
    private Integer dataInterval;
    private boolean mailNotification;
}
