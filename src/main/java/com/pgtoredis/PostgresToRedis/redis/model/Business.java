package com.pgtoredis.PostgresToRedis.redis.model;

import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.NumericIndexed;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.geo.Point;
import org.springframework.data.annotation.Id;
import java.sql.Timestamp;
@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "of")
//@Document(timeToLive = 3600)
public class Business {
    @Id @Indexed
    private Integer businessId;
    @Indexed
    private Integer vendorVendorId;

    private String businessprofileImagePath;
    @Indexed
    private String address;
    @Indexed
    private String businessName;
    @Indexed
    private Integer countryId;

    private Integer createdBy;
    @NumericIndexed
    private Timestamp createdTime;
    @Indexed
    private Integer defaultLandingPage;
    @Indexed
    private Integer defaultMap;
    @Indexed
    private Integer deletedBy;
    @Indexed
    private Timestamp deletedTime;

    private Integer firstDayOfWeek;

    private String googleMapKey;
    @Indexed
    private Point gpsLocation;
    @Indexed
    private boolean isActive;
    @Indexed
    private boolean isDeleted;

    private Integer language;

    private Integer mapView;

    private Integer menuView;
    @Indexed
    private String mobileNumber;
    @Indexed
    private Integer speedUnit;
    @Indexed
    private Integer timezoneId;
    @Indexed
    private String zipcode;
    @Indexed
    private Integer preferredLanguage;
    @Indexed
    private Boolean emailnotification;
    @Indexed
    private Boolean isMail;
    @Indexed
    private Boolean isSms;
    @Indexed
    private Boolean kycRequest;

    private Timestamp kycRequestTime;
    @Indexed
    private Integer dataInterval;
    @Indexed
    private boolean mailNotification;
}
