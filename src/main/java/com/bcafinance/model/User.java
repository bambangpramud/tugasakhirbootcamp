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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    private static final long serialversionUID = 1L;

    @Id
    @Column(name = "UserID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UniqID" , nullable = false, length = 255)
    private String uniqId;

    @Length(message = ConstantMessage.WARNING_DATA_EMPTY)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "CollectName" , nullable = false, length = 60)
    private String collectName;
//
//    @Length(message = ConstantMessage.WARNING_COLLECT_NAME_MANDATORY)
//    @NotEmpty(message = ConstantMessage.WARNING_COLLECT_NAME_MANDATORY)
//    @Column(name = "Criteria" , nullable = false, length = 60)
//    private String criteria;

    @Length(message = ConstantMessage.WARNING_DATA_EMPTY)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Coveran" , nullable = false, length = 60)
    private String coveran;

    @Length(message = ConstantMessage.WARNING_DATA_EMPTY)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Supervisor" , nullable = false, length = 60)
    private String supervisor;

    @Length(message = ConstantMessage.WARNING_DATA_EMPTY)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Head" , nullable = false, length = 60)
    private String head;

    @Length(message = ConstantMessage.WARNING_DATA_EMPTY)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "PhoneNumber" , nullable = false, length = 20,unique = true)
    private String phoneNumber;

    @Length(message = ConstantMessage.WARNING_DATA_EMPTY)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "Msisdn" , nullable = true, length = 20,unique = true)
    private String msisdn;

    @Length(message = ConstantMessage.WARNING_DATA_EMPTY)
    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
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

    @Column(name = "IsMobile",nullable = false)
    private boolean isMobile = true;

    @Column(name = "IsCMS",nullable = false)
    private boolean isCMS = true;

    @ManyToMany
    @JoinTable(
            name = "UserKunjungan",
            joinColumns = @JoinColumn(name="UserID",referencedColumnName = "UserID"),
            inverseJoinColumns = @JoinColumn(name = "KunjunganID",referencedColumnName = "KunjunganID")
    )
    private Set<Kunjungan> kunjungans = new HashSet<Kunjungan>();

}