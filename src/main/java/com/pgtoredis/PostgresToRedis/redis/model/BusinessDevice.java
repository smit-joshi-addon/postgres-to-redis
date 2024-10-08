package com.pgtoredis.PostgresToRedis.redis.model;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;

import com.redis.om.spring.annotations.NumericIndexed;
import lombok.*;
import org.springframework.core.annotation.Order;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor

@RequiredArgsConstructor(staticName = "of")
@Document(value = "BusinessDevice",timeToLive = 18120L)
public class BusinessDevice {
    @Id @Indexed
    private long businessDeviceId;
    @Indexed
    private Business businessBusinessId;
    @Indexed
    private Device deviceDeviceId;
    @Indexed
    private Package packagesPackageId;
    @Indexed
    private Vendor vendorVendorId;
    @NumericIndexed(sortable = true)
    private Timestamp createdTime;
    @NumericIndexed(sortable = true)
    private Timestamp deletedTime;
    @Indexed
    private boolean isActive;
    @Indexed
    private boolean isDeleted;

    private int lastObservationId;

    private int simcardId;

    private long businessIdBusinessId;

    private long createdByUserId;

    private long deviceIdDeviceId;
    @Indexed
    private int createdBy;

    private int businessBranchBusinessBranchId;
    @Indexed
    private String deviceAlias;
    @Indexed
    private boolean isGeofenceEnter;
    @Indexed
    private boolean isGeofenceExit;
    @Indexed
    private boolean isHardAcceleration;

    private boolean isHardBrake;

    private boolean isIgnitionOff;
    @Indexed
    private boolean isIgnitionOn;
    @Indexed
    private boolean isOverSpeed;

    private String selectedAlertType;
    @Indexed
    private boolean isAcOff;
    @Indexed
    private boolean isAcOn;

    private String selectedFeature;
    @Indexed
    private boolean isPowerCut;
    @Indexed
    private boolean isFallDown;
    @Indexed
    private boolean isLowBattery;
    @Indexed
    private boolean isPowerOn;
    @Indexed
    private boolean isSOS;
    @Indexed
    private boolean isFuelSupported;

    private int businessPackageId;

    private int p2pUserId;
    @Indexed
    private double todometer;
    @Indexed
    private double vodometer;

    private int positionId;
    @Indexed
    private int simcardSimcardId;

    private int vehicleimageidVehicleimageid;

    private boolean isFranchiseEnter;

    private boolean isFranchiseExit;
    @Indexed
    private boolean isRampOff;
    @Indexed
    private boolean isRampOn;

    private int liveobLiveObId;
    @Indexed
    private boolean isImmobilizer;
    @Indexed
    private boolean isTemperatureSupported;
    @Indexed
    private String observationUuid;

    private String vehicleimagename;
    @Indexed
    private String address;
    @Indexed
    private int driverId;
}

/*

        "FT.CREATE" "com.pgtoredis.PostgresToRedis.redis.model.DevicePackageExpireInfoIdx" "ON" "JSON"
                "PREFIX" "1" "DevicePackageExpireInfo" "LANGUAGE" "english"
                "SCHEMA" "$.packageExpireId" "AS" "packageExpireId" "NUMERIC"
                "$.businessDeviceBusinessDeviceId" "AS" "businessDeviceBusinessDeviceId" "NUMERIC"
                "$.isActive" "AS" "isActive" "TAG" "SEPARATOR" "|" "$.isDeleted" "AS" "isDeleted" "TAG""SEPARATOR" "|"
                "$.packageName" "AS" "packageName" "TAG" "SEPARATOR" "|" "$.packagesPackageId" "AS" "packagesPackageId" "NUMERIC"
                "$.vendorVendorId" "AS" "vendorVendorId" "NUMERIC"
*/


/*

         "FT.CREATE" "com.pgtoredis.PostgresToRedis.redis.model.BusinessDeviceIdx" "ON" "JSON"
                "PREFIX" "1" "BusinessDevice" "LANGUAGE" "english"
                "SCHEMA" "$.businessDeviceId" "AS" "businessDeviceId" "NUMERIC"
                "$.businessBusinessId.businessId" "AS" "businessBusinessId_businessId" "NUMERIC"
                "$.businessBusinessId.vendorVendorId" "AS" "businessBusinessId_vendorVendorId" "NUMERIC"
                "$.businessBusinessId.businessprofileImagePath" "AS" "businessBusinessId_businessprofileImagePath" "TAG" "SEPARATOR" "|"
                "$.businessBusinessId.address" "AS" "businessBusinessId_address" "TAG" "SEPARATOR" "|"
                "$.businessBusinessId.businessName" "AS" "businessBusinessId_businessName" "TAG" "SEPARATOR" "|"
                "$.businessBusinessId.countryId" "AS" "businessBusinessId_countryId" "NUMERIC"
                "$.businessBusinessId.createdBy" "AS" "businessBusinessId_createdBy" "NUMERIC"
                "$.businessBusinessId.defaultLandingPage" "AS" "businessBusinessId_defaultLandingPage" "NUMERIC"
                "$.businessBusinessId.defaultMap" "AS" "businessBusinessId_defaultMap" "NUMERIC"
                "$.businessBusinessId.deletedBy" "AS" "businessBusinessId_deletedBy" "NUMERIC"
                "$.businessBusinessId.firstDayOfWeek" "AS" "businessBusinessId_firstDayOfWeek" "NUMERIC"
                "$.businessBusinessId.googleMapKey" "AS" "businessBusinessId_googleMapKey" "TAG" "SEPARATOR" "|"
                "$.businessBusinessId.gpsLocation" "AS" "businessBusinessId_gpsLocation" "GEO"
                "$.businessBusinessId.isActive" "AS" "businessBusinessId_isActive" "TAG" "SEPARATOR" "|"
                "$.businessBusinessId.isDeleted" "AS" "businessBusinessId_isDeleted" "TAG" "SEPARATOR" "|"
                "$.businessBusinessId.language" "AS" "businessBusinessId_language" "NUMERIC"
                "$.businessBusinessId.mapView" "AS" "businessBusinessId_mapView" "NUMERIC"
                "$.businessBusinessId.menuView" "AS" "businessBusinessId_menuView" "NUMERIC"
                "$.businessBusinessId.mobileNumber" "AS" "businessBusinessId_mobileNumber" "TAG" "SEPARATOR" "|"
                "$.businessBusinessId.speedUnit" "AS" "businessBusinessId_speedUnit" "NUMERIC"
                "$.businessBusinessId.timezoneId" "AS" "businessBusinessId_timezoneId" "NUMERIC"
                "$.businessBusinessId.zipcode" "AS" "businessBusinessId_zipcode" "TAG" "SEPARATOR" "|"
                "$.businessBusinessId.preferredLanguage" "AS" "businessBusinessId_preferredLanguage" "NUMERIC"
                "$.businessBusinessId.emailnotification" "AS" "businessBusinessId_emailnotification" "TAG" "SEPARATOR" "|"
                "$.businessBusinessId.isMail" "AS" "businessBusinessId_isMail" "TAG" "SEPARATOR" "|"
                "$.businessBusinessId.isSms" "AS" "businessBusinessId_isSms" "TAG" "SEPARATOR" "|"
                "$.businessBusinessId.kycRequest" "AS" "businessBusinessId_kycRequest" "TAG" "SEPARATOR" "|"
                "$.businessBusinessId.dataInterval" "AS" "businessBusinessId_dataInterval" "NUMERIC"
                "$.businessBusinessId.mailNotification" "AS" "businessBusinessId_mailNotification" "TAG" "SEPARATOR" "|"
                "$.deviceDeviceId.deviceId" "AS" "deviceDeviceId_deviceId" "NUMERIC"
                "$.deviceDeviceId.vendorIdVendorId" "AS" "deviceDeviceId_vendorIdVendorId" "NUMERIC"
                "$.deviceDeviceId.createdBy" "AS" "deviceDeviceId_createdBy" "NUMERIC"
                "$.deviceDeviceId.deletedTime" "AS" "deviceDeviceId_deletedTime" "NUMERIC"
                "$.deviceDeviceId.isActive" "AS" "deviceDeviceId_isActive" "TAG" "SEPARATOR" "|"
                "$.deviceDeviceId.isAssign" "AS" "deviceDeviceId_isAssign" "TAG" "SEPARATOR" "|"
                "$.deviceDeviceId.isDeleted" "AS" "deviceDeviceId_isDeleted" "TAG" "SEPARATOR" "|"
                "$.deviceDeviceId.trackingType" "AS" "deviceDeviceId_trackingType" "NUMERIC"
                "$.deviceDeviceId.brandModelIdBrandModelId" "AS" "deviceDeviceId_brandModelIdBrandModelId" "NUMERIC"
                "$.deviceDeviceId.deviceBrandIdDeviceBrandId" "AS" "deviceDeviceId_deviceBrandIdDeviceBrandId" "NUMERIC"
                "$.deviceDeviceId.deletedBy" "AS" "deviceDeviceId_deletedBy" "NUMERIC"
                "$.deviceDeviceId.imei" "AS" "deviceDeviceId_imei" "TAG" "SEPARATOR" "|"
                "$.deviceDeviceId.status" "AS" "deviceDeviceId_status" "TAG" "SEPARATOR" "|"
                "$.deviceDeviceId.isP2PDevice" "AS" "deviceDeviceId_isP2PDevice" "TAG" "SEPARATOR" "|"
                "$.deviceDeviceId.comment" "AS" "deviceDeviceId_comment" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.packageId" "AS" "packagesPackageId_packageId" "NUMERIC"
                "$.packagesPackageId.vendorVendorId" "AS" "packagesPackageId_vendorVendorId" "NUMERIC"
                "$.packagesPackageId.createdBy" "AS" "packagesPackageId_createdBy" "NUMERIC"
                "$.packagesPackageId.feature" "AS" "packagesPackageId_feature" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.isActive" "AS" "packagesPackageId_isActive" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.isAttendanceForP2p" "AS" "packagesPackageId_isAttendanceForP2p" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.isBooking" "AS" "packagesPackageId_isBooking" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.isDeleted" "AS" "packagesPackageId_isDeleted" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.isDriver" "AS" "packagesPackageId_isDriver" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.isFms" "AS" "packagesPackageId_isFms" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.isFranchise" "AS" "packagesPackageId_isFranchise" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.isRouteAvailable" "AS" "packagesPackageId_isRouteAvailable" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.isRouteWithParentApp" "AS" "packagesPackageId_isRouteWithParentApp" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.isShareHistory" "AS" "packagesPackageId_isShareHistory" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.isTour" "AS" "packagesPackageId_isTour" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.monthlyPrice" "AS" "packagesPackageId_monthlyPrice" "NUMERIC"
                "$.packagesPackageId.packageName" "AS" "packagesPackageId_packageName" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.packageType" "AS" "packagesPackageId_packageType" "TAG" "SEPARATOR" "|"
                "$.packagesPackageId.setupFees" "AS" "packagesPackageId_setupFees" "NUMERIC"
                "$.packagesPackageId.yearlyPrice" "AS" "packagesPackageId_yearlyPrice" "NUMERIC"
                "$.vendorVendorId.vendorId" "AS" "vendorVendorId_vendorId" "NUMERIC"
                "$.vendorVendorId.businessFileName" "AS" "vendorVendorId_businessFileName" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.deletedBy" "AS" "vendorVendorId_deletedBy" "NUMERIC"
                "$.vendorVendorId.deviceFileName" "AS" "vendorVendorId_deviceFileName" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.deviceLimit" "AS" "vendorVendorId_deviceLimit" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.fromEmail" "AS" "vendorVendorId_fromEmail" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.fromName" "AS" "vendorVendorId_fromName" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.hostName" "AS" "vendorVendorId_hostName" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.vendorAddress" "AS" "vendorVendorId_vendorAddress" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.vendorBusinessName" "AS" "vendorVendorId_vendorBusinessName" "TAG" "SEPARATOR" "|"
        "$.vendorVendorId.vendorCity" "AS" "vendorVendorId_vendorCity" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.vendorEmail" "AS" "vendorVendorId_vendorEmail" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.vendorLogo" "AS" "vendorVendorId_vendorLogo" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.vendorName" "AS" "vendorVendorId_vendorName" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.vendorPhone" "AS" "vendorVendorId_vendorPhone" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.vendorSupportEmail" "AS" "vendorVendorId_vendorSupportEmail" "TAG""SEPARATOR" "|"
                "$.vendorVendorId.vendorSupportPhone" "AS" "vendorVendorId_vendorSupportPhone" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.isDeleted" "AS" "vendorVendorId_isDeleted" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.vendorSupportPhone2" "AS" "vendorVendorId_vendorSupportPhone2" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.username" "AS" "vendorVendorId_username" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.isPackage" "AS" "vendorVendorId_isPackage" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.kycAuthority" "AS" "vendorVendorId_kycAuthority" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.isActive" "AS" "vendorVendorId_isActive" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.paymentReminder" "AS" "vendorVendorId_paymentReminder" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.isSms" "AS" "vendorVendorId_isSms" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.key" "AS" "vendorVendorId_key" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.mobileNum" "AS" "vendorVendorId_mobileNum" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.templateId" "AS" "vendorVendorId_templateId" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.url" "AS" "vendorVendorId_url" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.senderId" "AS" "vendorVendorId_senderId" "NUMERIC"
                "$.vendorVendorId.packageFileName" "AS" "vendorVendorId_packageFileName" "TAG" "SEPARATOR" "|"
                "$.vendorVendorId.userPassword" "AS" "vendorVendorId_userPassword" "TAG" "SEPARATOR" "|"
                "$.createdTime" "AS" "createdTime" "NUMERIC" "$.isActive" "AS" "isActive" "TAG" "SEPARATOR" "|"
                "$.isDeleted" "AS" "isDeleted" "TAG" "SEPARATOR" "|"
                "$.lastObservationId" "AS" "lastObservationId" "NUMERIC"
                "$.simcardId" "AS" "simcardId" "NUMERIC" "$.businessIdBusinessId" "AS" "businessIdBusinessId" "NUMERIC"
                "$.createdByUserId" "AS" "createdByUserId" "NUMERIC" "$.deviceIdDeviceId" "AS" "deviceIdDeviceId" "NUMERIC"
                "$.createdBy" "AS" "createdBy" "NUMERIC"
                "$.businessBranchBusinessBranchId" "AS" "businessBranchBusinessBranchId" "NUMERIC"
                "$.deviceAlias" "AS" "deviceAlias" "TAG" "SEPARATOR" "|"
                "$.isGeofenceEnter" "AS" "isGeofenceEnter" "TAG" "SEPARATOR" "|"
                "$.isGeofenceExit" "AS" "isGeofenceExit" "TAG" "SEPARATOR" "|"
                "$.isHardAcceleration" "AS" "isHardAcceleration" "TAG" "SEPARATOR" "|"
                "$.isHardBrake" "AS" "isHardBrake" "TAG" "SEPARATOR" "|"
                "$.isIgnitionOff" "AS" "isIgnitionOff" "TAG" "SEPARATOR" "|"
                "$.isIgnitionOn" "AS" "isIgnitionOn" "TAG" "SEPARATOR" "|"
                "$.isOverSpeed" "AS" "isOverSpeed" "TAG" "SEPARATOR" "|"
                "$.selectedAlertType" "AS" "selectedAlertType" "TAG" "SEPARATOR" "|"
                "$.isAcOff" "AS" "isAcOff" "TAG" "SEPARATOR" "|"
                "$.isAcOn" "AS" "isAcOn" "TAG" "SEPARATOR" "|"
                "$.selectedFeature" "AS" "selectedFeature" "TAG" "SEPARATOR" "|"
                "$.isPowerCut" "AS" "isPowerCut" "TAG" "SEPARATOR" "|"
                "$.isFallDown" "AS" "isFallDown" "TAG" "SEPARATOR" "|"
                "$.isLowBattery" "AS" "isLowBattery" "TAG" "SEPARATOR" "|"
                "$.isPowerOn" "AS" "isPowerOn" "TAG" "SEPARATOR" "|"
                "$.isSOS" "AS" "isSOS" "TAG" "SEPARATOR" "|" "$.isFuelSupported" "AS" "isFuelSupported" "TAG" "SEPARATOR" "|"
                "$.businessPackageId" "AS" "businessPackageId" "NUMERIC" "$.p2pUserId" "AS" "p2pUserId" "NUMERIC"
                "$.todometer" "AS" "todometer" "NUMERIC" "$.vodometer" "AS" "vodometer" "NUMERIC"
                "$.positionId" "AS" "positionId" "NUMERIC" "$.simcardSimcardId" "AS" "simcardSimcardId" "NUMERIC"
                "$.vehicleimageidVehicleimageid" "AS" "vehicleimageidVehicleimageid" "NUMERIC"
                "$.isFranchiseEnter" "AS" "isFranchiseEnter" "TAG" "SEPARATOR" "|"
                "$.isFranchiseExit" "AS" "isFranchiseExit" "TAG" "SEPARATOR" "|"
                "$.isRampOff" "AS" "isRampOff" "TAG" "SEPARATOR" "|" "$.isRampOn" "AS" "isRampOn" "TAG"
                "SEPARATOR" "|" "$.liveobLiveObId" "AS" "liveobLiveObId" "NUMERIC"
                "$.isImmobilizer" "AS" "isImmobilizer" "TAG" "SEPARATOR" "|"
                "$.isTemperatureSupported" "AS" "isTemperatureSupported" "TAG" "SEPARATOR" "|"
                "$.observationUuid" "AS" "observationUuid" "TAG" "SEPARATOR" "|"
                "$.vehicleimagename" "AS" "vehicleimagename" "TAG" "SEPARATOR" "|"
                "$.address" "AS" "address" "TAG" "SEPARATOR" "|" "$.driverId" "AS" "driverId" "NUMERIC"
*/
