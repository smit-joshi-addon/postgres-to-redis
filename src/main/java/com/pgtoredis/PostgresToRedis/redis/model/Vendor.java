package com.pgtoredis.PostgresToRedis.redis.model;


import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
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
public class Vendor {
    @Id @Indexed
    private Integer vendorId;
    @Indexed
    //    @Column(name = "business_file_name")
    private String businessFileName;
    @Indexed
    //    @Column(name = "deleted_by")
    private Integer deletedBy;
    @Indexed
    //    @Column(name = "deleted_time")
    private Timestamp deletedTime;
    @Indexed
    //    @Column(name = "device_file_name")
    private String deviceFileName;
    @Indexed
    //    @Column(name = "device_limit")
    private String deviceLimit;
    @Indexed
    //    @Column(name = "from_email")
    private String fromEmail;
    @Indexed
    //    @Column(name = "from_name")
    private String fromName;
    @Indexed
    //    @Column(name = "host_name")
    private String hostName;
    @Indexed
    //    @Column(name = "vendor_address")
    private String vendorAddress;
    @Indexed
    //@Column(name = "vendor_business_name")
    private String vendorBusinessName;
    @Indexed
    //@Column(name = "vendor_city")
    private String vendorCity;
    @Indexed
    // @Column(name = "vendor_email")
    private String vendorEmail;
    @Indexed
    //@Column(name = "vendor_logo")
    private String vendorLogo;
    @Indexed
    //@Column(name = "vendor_name")
    private String vendorName;
    @Indexed
    //@Column(name = "vendor_phone")
    private String vendorPhone;
    @Indexed
    //@Column(name = "vendor_support_email")
    private String vendorSupportEmail;
    @Indexed
    //@Column(name = "vendor_support_phone")
    private String vendorSupportPhone;
    @Indexed
    //@Column(name = "is_deleted")
    private boolean isDeleted;

    /*@Column(name = "role_role_id")
    private Integer roleRoleId;*/

    @Indexed
    //@Column(name = "vendor_support_phone_2")
    private String vendorSupportPhone2;

    /*@Column(name = "password")
    private String password;*/

    @Indexed
    @Column(name = "username")
    private String username;
    /*@Indexed
    @Column(name = "user_name")
    private String userName;*/

    @Indexed
    //@Column(name = "is_package")
    private Boolean isPackage;
    @Indexed
    //    @Column(name = "kyc_authority")
    private Boolean kycAuthority;
    @Indexed
    //    @Column(name = "is_active")
    private boolean isActive;
    @Indexed
    //    @Column(name = "payment_reminder")
    private boolean paymentReminder;
    @Indexed
    //    @Column(name = "payment_reminder_time")
    private Timestamp paymentReminderTime;
    @Indexed
    //@Column(name = "is_sms")
    private boolean isSms;
    @Indexed
    //    @Column(name = "key")
    private String key;
    @Indexed
    //    @Column(name = "mobile_num")
    private String mobileNum;
    @Indexed
    //    @Column(name = "template_id")
    private String templateId;
    @Indexed
    //    @Column(name = "url")
    private String url;
    @Indexed
    //    @Column(name = "sender_id")
    private int senderId;

    //    @Column(name = "package_file_name")
    private String packageFileName;

    //    @Column(name = "user_password")
    private String userPassword;


}
