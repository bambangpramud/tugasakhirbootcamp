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

    @Column(name = "PhoneNumber1", length = 16, nullable = false, unique = true)
    private String phoneNumber1;

    @Column(name = "PhoneNumber2", length = 16, nullable = false, unique = true)
    private String phoneNumber2;

    @Column(name = "FotoRumah", length = 225, nullable = false, unique = true)
    private String fotoRumah;

    @Column(name = "FotoKTP", length = 225, nullable = false, unique = true)
    private String fotoKtp;

    @NotEmpty(message = ConstantMessage.WARNING_DATA_EMPTY)
    @Column(name = "IsSpt")
    private boolean isSpt;

    @Column(name = "DiterimaOleh", length = 50, nullable = false, unique = true)
    private String diterimaOleh;

    @Column(name = "JamDiterima", length = 16, nullable = false, unique = true)
    private String jamDiterima;



    @ManyToMany(mappedBy = "kunjungans")
    @JsonBackReference
    private Set<Account> account = new HashSet<Account>();

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

    public Set<Account> getAccount() {
        return account;
    }

    public void setAccount(Set<Account> seller) {
        this.account = seller;
    }
}
