/*
@Author bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 1/11/2023  10:31 AM
Last Modified on 1/11/202310:31 AM
Version 1.0
*/


package com.bcafinance.model;

import com.bcafinance.utils.ConstantMessage;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Kunjungan")
public class Kunjungan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KunjunganId")
    private Long id;


    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "StatusKonsumen", length = 25)
    private String statusKonsumen;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "StatusUnit", length = 25)
    private String statusUnit;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "StatusAlamat", length = 25)
    private String statusAlamat;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "BertemuDengan", length = 50)
    private String bertemuDengan;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "HasilKunjungan", length = 50)
    private String hasilKunjungan;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "MailAddress", length = 225)
    private String mailAddress;

    @Column(name = "PhoneNumber1", length = 16, nullable = false)
    private String phoneNumber1;

    @Column(name = "PhoneNumber2", length = 16, nullable = false)
    private String phoneNumber2;

    @Column(name = "FotoRumah", length = 225, nullable = false, unique = true)
    private String fotoRumah;

    @Column(name = "FotoKTP", length = 225, nullable = false, unique = true)
    private String fotoKtp;


    @Column(name = "IsSpt")
    private boolean isSpt;

    @Column(name = "DiterimaOleh", length = 50, nullable = false)
    private String diterimaOleh;

    @Column(name = "JamDiterima", length = 16, nullable = false)
    private String jamDiterima;


    @NotNull(message = ConstantMessage.WARNING_DATA_EMPTY)

    @Column(name = "PostalCode")
    private Integer postalCode;

    @NotNull(message = ConstantMessage.WARNING_DATA_EMPTY)
//    @Column(name = "City",length = 50,nullable = false,unique = true)
    @Column(name = "AgingDate")
    private LocalDate agingDate;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Remark",length = 225)
    private String remark;

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    //
//    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "GPS",length = 225)
    private String gps;



    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "AccountId")
    private Account account;


    @Column(name = "CreatedBy",nullable = false)
    private String createdBy = "1";

    @Column(name = "CreatedDate",nullable = false)
    private Date createdDate = new Date();//JANGAN GUNAKAN columnDefinition untuk set default kolom, langsung set di variabel nya saja.

    @Column(name = "ModifiedBy",nullable = true)
    private String modifiedBy ;

    @Column(name = "ModifiedDate",nullable = true)
    private Date modifiedDate;

    @Column(name = "IsActive",nullable = false)
    private boolean isActive = true;


    //--------------------GETTER SETTER ------------------------------------//


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public LocalDate getAgingDate() {
        return agingDate;
    }

    public void setAgingDate(LocalDate agingDate) {
        this.agingDate = agingDate;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
