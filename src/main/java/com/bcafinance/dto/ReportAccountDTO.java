/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 1/13/2023  10:43 AM
Last Modified on 1/13/202310:43 AM
Version 1.0
*/


package com.bcafinance.dto;

import java.time.LocalDate;

public class ReportAccountDTO {

    private Long id;

    private String accountNumber;

    private String homeAddress;

    private String name;

    private LocalDate agingDate;

    private boolean isPriority;

    private String coveran;

    private Integer postalCode;

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

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAgingDate() {
        return agingDate;
    }

    public void setAgingDate(LocalDate agingDate) {
        this.agingDate = agingDate;
    }

    public boolean isPriority() {
        return isPriority;
    }

    public void setPriority(boolean priority) {
        isPriority = priority;
    }

    public String getCoveran() {
        return coveran;
    }

    public void setCoveran(String coveran) {
        this.coveran = coveran;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
}
