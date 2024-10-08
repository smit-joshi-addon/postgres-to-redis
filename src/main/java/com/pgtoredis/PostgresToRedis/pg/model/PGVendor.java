package com.pgtoredis.PostgresToRedis.pg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "vendor", schema = "web")
public class PGVendor {
    @Id
    @Column(name = "vendor_id")
    private Integer vendorId;

    //    @Column(name = "business_file_name")
    private String businessFileName;

    //    @Column(name = "deleted_by")
    private Integer deletedBy;

    //    @Column(name = "deleted_time")
    private Timestamp deletedTime;

    //    @Column(name = "device_file_name")
    private String deviceFileName;

    //    @Column(name = "device_limit")
    private Integer deviceLimit;

    //    @Column(name = "from_email")
    private String fromEmail;

    //    @Column(name = "from_name")
    private String fromName;

    //    @Column(name = "host_name")
    private String hostName;

    @Column(name = "vendor_address")
    private String vendorAddress;

    //@Column(name = "vendor_business_name")
    private String vendorBusinessName;

    //@Column(name = "vendor_city")
    private String vendorCity;

    // @Column(name = "vendor_email")
    private String vendorEmail;

    //@Column(name = "vendor_logo")
    private String vendorLogo;

    //@Column(name = "vendor_name")
    private String vendorName;

    //@Column(name = "vendor_phone")
    private String vendorPhone;

    //@Column(name = "vendor_support_email")
    private String vendorSupportEmail;

    //@Column(name = "vendor_support_phone")
    private String vendorSupportPhone;

    /*@Column(name = "role_role_id")
    private Integer roleRoleId;*/

    @Column(name = "vendor_support_phone_2")
    private String vendorSupportPhone2;

    /*@Column(name = "password")
    private String password;*/

    @Column(name = "username")
    private String username;
    // @Column(name = "user_name")
    // private String userName;


    //    @Column(name = "kyc_authority")
    private Boolean kycAuthority;

    //    @Column(name = "is_active")
    private boolean isActive;
    //@Column(name = "is_deleted")
    private boolean isDeleted;
    //@Column(name = "is_package")
    private Boolean isPackage;
    //@Column(name = "is_sms")
    private boolean isSms;


    //    @Column(name = "package_file_name")
    private String packageFileName;
    //    @Column(name = "payment_reminder")
    private boolean paymentReminder;

    //    @Column(name = "payment_reminder_time")
    private Timestamp paymentReminderTime;


    //    @Column(name = "key")
    private String key;

    //    @Column(name = "mobile_num")
    private String mobileNum;

    //    @Column(name = "template_id")
    private String templateId;

    //    @Column(name = "url")
    private String url;

    //    @Column(name = "sender_id")
    private String senderId;

    //    @Column(name = "user_password")
    private String userPassword;

}
