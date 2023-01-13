package com.bcafinance.dto;
/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition) 
@Author ASUS a.k.a. Archan
ITDP 7
Created on 12/01/2023
@Last Modified on 12/01/2023 10:54
Version 1.0
*/

import com.bcafinance.utils.ConstantMessage;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class UserDTO {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    @Length(message = ConstantMessage.WARNING_REQUIRED)
    @NotEmpty(message = ConstantMessage.WARNING_LENGHT)
    private String uniqId;

    @Length(message = ConstantMessage.WARNING_REQUIRED)
    @NotEmpty(message = ConstantMessage.WARNING_LENGHT)
    private String collectName;

    @Length(message = ConstantMessage.WARNING_REQUIRED)
    @NotEmpty(message = ConstantMessage.WARNING_LENGHT)
    private String type;

    @Length(message = ConstantMessage.WARNING_REQUIRED)
    @NotEmpty(message = ConstantMessage.WARNING_LENGHT)
    private String title;

    @Length(message = ConstantMessage.WARNING_REQUIRED)
    @NotEmpty(message = ConstantMessage.WARNING_LENGHT)
    private String password;

    @Length(message = ConstantMessage.WARNING_REQUIRED)
    @NotEmpty(message = ConstantMessage.WARNING_LENGHT)
    private String coveran;

    @Length(message = ConstantMessage.WARNING_REQUIRED)
    @NotEmpty(message = ConstantMessage.WARNING_LENGHT)
    private String phoneNumber;

    @Length(message = ConstantMessage.WARNING_REQUIRED)
    @NotEmpty(message = ConstantMessage.WARNING_LENGHT)
    private String msisdn;

    @Length(message = ConstantMessage.WARNING_REQUIRED)
    @NotEmpty(message = ConstantMessage.WARNING_LENGHT)
    private String remark;

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    private boolean isActivated ;

    private boolean isMobile;

    private boolean isCMS;

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
