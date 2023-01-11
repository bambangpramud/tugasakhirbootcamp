/*
@Author bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 1/11/2023  10:29 AM
Last Modified on 1/11/202310:29 AM
Version 1.0
*/


package com.bcafinance.model;

import com.bcafinance.utils.ConstantMessage;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "UjianAkhir")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountId")
    private Long id;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
//    @Column(name = "City",length = 50,nullable = false,unique = true)
    @Column(name = "AccountNumber",length = 50,unique = true)
    private String accountNumber;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Name",length = 50 ,unique = true)
    private String name;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Type", length = 25)
    private String type;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "StatusKunjungan", length = 25)
    private String statusKunjungan;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "IsPriority")
    private boolean isPriority;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Customer", length = 100)
    private String customer;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "SpouseName", length = 50)
    private String spouseName;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "KTPAddress", length = 225)
    private String ktpAddress;
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "HomeAddress", length = 225)
    private String homeAddress;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "MailAddress", length = 225)
    private String mailAddress;

    @Column(name = "PhoneNumber1", length = 16, nullable = false, unique = true)
    private String phoneNumber1;

    @Column(name = "PhoneNumber2", length = 16, nullable = false, unique = true)
    private String phoneNumber2;


    @ManyToMany
    @JoinTable(
            name = "AccountKunjungan",
            joinColumns = @JoinColumn(name="AccountId",referencedColumnName = "AccountId"),
            inverseJoinColumns = @JoinColumn(name = "KunjunganId",referencedColumnName = "KunjunganId")
    )
    private Set<Kunjungan> kunjungans = new HashSet<Kunjungan>();


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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatusKunjungan() {
        return statusKunjungan;
    }

    public void setStatusKunjungan(String statusKunjungan) {
        this.statusKunjungan = statusKunjungan;
    }

    public boolean isPriority() {
        return isPriority;
    }

    public void setPriority(boolean priority) {
        isPriority = priority;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
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

    public Set<Kunjungan> getKunjungans() {
        return kunjungans;
    }

    public void setKunjungans(Set<Kunjungan> kunjungans) {
        this.kunjungans = kunjungans;
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

    public String getKtpAddress() {
        return ktpAddress;
    }

    public void setKtpAddress(String ktpAddress) {
        this.ktpAddress = ktpAddress;
    }
}
