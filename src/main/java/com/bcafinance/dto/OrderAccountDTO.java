/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 1/12/2023  9:31 AM
Last Modified on 1/12/20239:31 AM
Version 1.0
*/


package com.bcafinance.dto;

public class OrderAccountDTO {

    private Long id;

    private String accountNumber;

    private String name;

    private String type;

    private boolean isPriority;

    private String coveran;

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
}
