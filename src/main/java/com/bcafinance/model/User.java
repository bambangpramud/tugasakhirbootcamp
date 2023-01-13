package com.bcafinance.model;
/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition) 
@Author ASUS a.k.a. Archan
ITDP 7
Created on 11/01/2023
@Last Modified on 11/01/2023 15:55
Version 1.0
*/


import com.bcafinance.utils.ConstantMessage;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User implements Serializable {

    private static final long serialversionUID = 1L;

    @Id
    @Column(name = "UserID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(message = ConstantMessage.WARNING_REQUIRED)
    @NotEmpty(message = ConstantMessage.WARNING_LENGHT)
    @Column(name = "UniqID" , nullable = false, length = 255,unique = true)
    private String uniqId;

    @Length(message = ConstantMessage.WARNING_LENGHT)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "CollectName" , nullable = false, length = 60)
    private String collectName;

    @Length(message = ConstantMessage.WARNING_DATA_EMPTY)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Type" , nullable = false, length = 60)
    private String type;

    @Length(message = ConstantMessage.WARNING_DATA_EMPTY)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Title" , nullable = false, length = 60)
    private String title;

    @Length(message = ConstantMessage.WARNING_DATA_EMPTY)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Password" , nullable = false, length = 60)
    private String password;

    @Length(message = ConstantMessage.WARNING_DATA_EMPTY)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Coveran" , nullable = false, length = 60)
    private String coveran;

    @Length(message = ConstantMessage.WARNING_DATA_EMPTY)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "PhoneNumber" , nullable = false, length = 20,unique = true)
    private String phoneNumber;

    @Length(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Msisdn" , nullable = true, length = 20,unique = true)
    private String msisdn;

    @Length(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Remark" , nullable = true, length = 255)
    private String remark;

    @Column(name = "CreatedBy",nullable = false)
    private String createdBy = "1";

    //    @Column(name = "CreatedDate",nullable = true, columnDefinition = "datetime2(7) DEFAULT GETDATE() ")
    @Column(name = "CreatedDate",nullable = false)
    private Date createdDate = new Date();//JANGAN GUNAKAN columnDefinition untuk set default kolom, langsung set di variabel nya saja.

    @Column(name = "ModifiedBy",nullable = true)
    private String modifiedBy ;

    @Column(name = "ModifiedDate",nullable = true)
    private Date modifiedDate;

    @Column(name = "IsActive",nullable = false)
    private boolean isActive = true;


    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    @Column(name = "IsActivated",nullable = false)
    private boolean isActivated = false;

    @Column(name = "IsMobile",nullable = false)
    private boolean isMobile = false;

    @Column(name = "IsCMS",nullable = false)
    private boolean isCMS = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniqId() {
        return uniqId;
    }

    public void setUniqId(String uniqId) {
        this.uniqId = uniqId;
    }

    public String getCollectName() {
        return collectName;
    }

    public void setCollectName(String collectName) {
        this.collectName = collectName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCoveran() {
        return coveran;
    }

    public void setCoveran(String coveran) {
        this.coveran = coveran;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isMobile() {
        return isMobile;
    }

    public void setMobile(boolean mobile) {
        isMobile = mobile;
    }

    public boolean isCMS() {
        return isCMS;
    }

    public void setCMS(boolean CMS) {
        isCMS = CMS;
    }




}

