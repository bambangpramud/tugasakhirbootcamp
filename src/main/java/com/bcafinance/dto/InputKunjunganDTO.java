/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 1/13/2023  3:55 PM
Last Modified on 1/13/20233:55 PM
Version 1.0
*/


package com.bcafinance.dto;

import com.bcafinance.model.Account;
import com.bcafinance.model.User;
import com.bcafinance.utils.ConstantMessage;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

public class InputKunjunganDTO {

    private String statusKonsumen;


    private String statusUnit;

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    private String gps;

    private String statusAlamat;

    private String bertemuDengan;

    private String hasilKunjungan;


    private String mailAddress;

    private String phoneNumber1;

    private String phoneNumber2;

    private String fotoRumah;

    private String fotoKtp;

    private boolean isSpt;

    private String diterimaOleh;

    private String jamDiterima;

    private Integer postalCode;

    private String agingDate;

    private String remark;



    private Long userId;


    private Long accountId;

    private String createdBy = "1";


    private Date createdDate = new Date();//JANGAN GUNAKAN columnDefinition untuk set default kolom, langsung set di variabel nya saja.


    private String modifiedBy ;

    private Date modifiedDate;

    private boolean isActive = true;

    public String getStatusKonsumen() {
        return statusKonsumen;
    }

    public void setStatusKonsumen(String statusKonsumen) {
        this.statusKonsumen = statusKonsumen;
    }

    public String getStatusUnit() {
        return statusUnit;
    }

    public void setStatusUnit(String statusUnit) {
        this.statusUnit = statusUnit;
    }

    public String getStatusAlamat() {
        return statusAlamat;
    }

    public void setStatusAlamat(String statusAlamat) {
        this.statusAlamat = statusAlamat;
    }

    public String getBertemuDengan() {
        return bertemuDengan;
    }

    public void setBertemuDengan(String bertemuDengan) {
        this.bertemuDengan = bertemuDengan;
    }

    public String getHasilKunjungan() {
        return hasilKunjungan;
    }

    public void setHasilKunjungan(String hasilKunjungan) {
        this.hasilKunjungan = hasilKunjungan;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getFotoRumah() {
        return fotoRumah;
    }

    public void setFotoRumah(String fotoRumah) {
        this.fotoRumah = fotoRumah;
    }

    public String getFotoKtp() {
        return fotoKtp;
    }

    public void setFotoKtp(String fotoKtp) {
        this.fotoKtp = fotoKtp;
    }

    public boolean isSpt() {
        return isSpt;
    }

    public void setSpt(boolean spt) {
        isSpt = spt;
    }

    public String getDiterimaOleh() {
        return diterimaOleh;
    }

    public void setDiterimaOleh(String diterimaOleh) {
        this.diterimaOleh = diterimaOleh;
    }

    public String getJamDiterima() {
        return jamDiterima;
    }

    public void setJamDiterima(String jamDiterima) {
        this.jamDiterima = jamDiterima;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getAgingDate() {
        return agingDate;
    }

    public void setAgingDate(String agingDate) {
        this.agingDate = agingDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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
}
