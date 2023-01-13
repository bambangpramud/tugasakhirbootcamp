/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 1/11/2023  11:53 AM
Last Modified on 1/11/202311:53 AM
Version 1.0
*/


package com.bcafinance.services;

import com.bcafinance.dto.InputKunjunganDTO;
import com.bcafinance.handler.ResourceNotFoundException;
import com.bcafinance.model.Account;
import com.bcafinance.model.Kunjungan;
import com.bcafinance.model.User;
import com.bcafinance.repos.AccountRepo;
import com.bcafinance.repos.KunjunganRepo;
import com.bcafinance.repos.UserRepo;
import com.bcafinance.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
public class KunjunganService {

    @Autowired
    private KunjunganRepo kunrepo;
@Autowired
    private UserRepo userepo;
    @Autowired
    private AccountRepo accrepo;

//    @Autowired
//    public KunjunganService(KunjunganRepo kunrepo){
//        this.kunrepo=kunrepo;
//    }
//    @Autowired
//    public KunjunganService(UserRepo userepo){
//        this.userepo =userepo;
//    }
//    @Autowired
//    public KunjunganService(KunjunganRepo kunrepo){
//        this.kunrepo=kunrepo;
//    }


public void addKunjungan(Kunjungan kunjungan) throws Exception{

    kunrepo.save(kunjungan);
}

public void addInputKunjungan(InputKunjunganDTO inputKunjungan) throws Exception{

       Kunjungan kunjungan = new Kunjungan();
       User user = userepo.getUserById(inputKunjungan.getUserId());
    Account account = accrepo.getById(inputKunjungan.getAccountId());

    kunjungan.setStatusKonsumen(inputKunjungan.getStatusKonsumen());
    kunjungan.setStatusUnit(inputKunjungan.getStatusUnit());
    kunjungan.setStatusAlamat(inputKunjungan.getStatusAlamat());
    kunjungan.setBertemuDengan(inputKunjungan.getBertemuDengan());
    kunjungan.setHasilKunjungan(inputKunjungan.getHasilKunjungan());
    kunjungan.setMailAddress(inputKunjungan.getMailAddress());
    kunjungan.setPhoneNumber1(inputKunjungan.getPhoneNumber1());
    kunjungan.setPhoneNumber2(inputKunjungan.getPhoneNumber2());
    kunjungan.setFotoRumah(inputKunjungan.getFotoRumah());
    kunjungan.setFotoKtp(inputKunjungan.getFotoKtp());
    kunjungan.setSpt(inputKunjungan.isSpt());
    kunjungan.setDiterimaOleh(inputKunjungan.getDiterimaOleh());
    kunjungan.setJamDiterima(inputKunjungan.getJamDiterima());
    kunjungan.setPostalCode(inputKunjungan.getPostalCode());
    kunjungan.setAgingDate(LocalDate.parse(inputKunjungan.getAgingDate()));
    kunjungan.setRemark(inputKunjungan.getRemark());
    kunjungan.setUser(user);
    kunjungan.setAccount(account);
    kunjungan.setCreatedBy(inputKunjungan.getCreatedBy());

    kunrepo.save(kunjungan);

}

    @Transactional
public void updateKunjungan(Kunjungan kunjunganParam) throws ResourceNotFoundException {

Kunjungan kunjungan = kunrepo.findById(kunjunganParam.getId()).orElseThrow(()->
        new ResourceNotFoundException(ConstantMessage.WARNING_CUSTOMER_NOT_FOUND));

    kunjungan.setModifiedBy("1");
    kunjungan.setModifiedDate(new Date());

    if (kunjunganParam.getStatusKonsumen()!=null
            && !Objects.equals(kunjungan.getStatusKonsumen(),kunjunganParam.getStatusKonsumen())
            && !kunjunganParam.getStatusKonsumen().equals("")){
        kunjungan.setStatusKonsumen(kunjunganParam.getStatusKonsumen());
    }
    if (kunjunganParam.getStatusUnit()!=null
            && !Objects.equals(kunjungan.getStatusUnit(),kunjunganParam.getStatusUnit())
            && !kunjunganParam.getStatusUnit().equals("")){
        kunjungan.setStatusUnit(kunjunganParam.getStatusUnit());
    }
    if (kunjunganParam.getStatusAlamat()!=null
            && !Objects.equals(kunjungan.getStatusAlamat(),kunjunganParam.getStatusAlamat())
            && !kunjunganParam.getStatusAlamat().equals("")){
        kunjungan.setStatusAlamat(kunjunganParam.getStatusAlamat());
    }
    if (kunjunganParam.getJamDiterima()!=null
            && !Objects.equals(kunjungan.getJamDiterima(),kunjunganParam.getJamDiterima())
            && !kunjunganParam.getJamDiterima().equals("")){
        kunjungan.setJamDiterima(kunjunganParam.getJamDiterima());
    }
    if (kunjunganParam.getBertemuDengan()!=null
            && !Objects.equals(kunjungan.getBertemuDengan(),kunjunganParam.getBertemuDengan())
            && !kunjunganParam.getBertemuDengan().equals("")){
        kunjungan.setBertemuDengan(kunjunganParam.getBertemuDengan());
    }
    if (kunjunganParam.getHasilKunjungan()!=null
            && !Objects.equals(kunjungan.getHasilKunjungan(),kunjunganParam.getHasilKunjungan())
            && !kunjunganParam.getHasilKunjungan().equals("")){
        kunjungan.setHasilKunjungan(kunjunganParam.getHasilKunjungan());
    }
    if (kunjunganParam.getMailAddress()!=null
            && !Objects.equals(kunjungan.getMailAddress(),kunjunganParam.getMailAddress())
            && !kunjunganParam.getMailAddress().equals("")){
        kunjungan.setMailAddress(kunjunganParam.getMailAddress());
    }
    if (kunjunganParam.getPhoneNumber1()!=null
            && !Objects.equals(kunjungan.getPhoneNumber1(),kunjunganParam.getPhoneNumber1())
            && !kunjunganParam.getPhoneNumber1().equals("")){
        kunjungan.setPhoneNumber1(kunjunganParam.getPhoneNumber1());
    }
        if (kunjunganParam.getPhoneNumber2()!=null
                && !Objects.equals(kunjungan.getPhoneNumber2(),kunjunganParam.getPhoneNumber2())
                && !kunjunganParam.getPhoneNumber2().equals("")){
            kunjungan.setPhoneNumber2(kunjunganParam.getPhoneNumber2());
        }
    if (kunjunganParam.getRemark()!=null
            && !Objects.equals(kunjungan.getRemark(),kunjunganParam.getRemark())
            && !kunjunganParam.getRemark().equals("")){
        kunjungan.setRemark(kunjunganParam.getRemark());
    }
    if (kunjunganParam.getFotoRumah()!=null
            && !Objects.equals(kunjungan.getFotoRumah(),kunjunganParam.getFotoRumah())
            && !kunjunganParam.getFotoRumah().equals("")){
        kunjungan.setFotoRumah(kunjunganParam.getFotoRumah());
    }
    if (kunjunganParam.getFotoKtp()!=null
            && !Objects.equals(kunjungan.getFotoKtp(),kunjunganParam.getFotoKtp())
            && !kunjunganParam.getFotoKtp().equals("")){
        kunjungan.setFotoKtp(kunjunganParam.getFotoKtp());
    }
    if (kunjunganParam.getStatusKonsumen()!=null
            && !Objects.equals(kunjungan.getStatusKonsumen(),kunjunganParam.getStatusKonsumen())
            && !kunjunganParam.getStatusKonsumen().equals("")){
        kunjungan.setStatusKonsumen(kunjunganParam.getStatusKonsumen());
    }
    kunjungan.setSpt(kunjunganParam.isSpt());

    if (kunjunganParam.getDiterimaOleh()!=null
            && !Objects.equals(kunjungan.getDiterimaOleh(),kunjunganParam.getDiterimaOleh())
            && !kunjunganParam.getDiterimaOleh().equals("")){
        kunjungan.setDiterimaOleh(kunjunganParam.getDiterimaOleh());
    }
        if (kunjunganParam.getDiterimaOleh()!=null
                && !Objects.equals(kunjungan.getDiterimaOleh(),kunjunganParam.getDiterimaOleh())
                && !kunjunganParam.getDiterimaOleh().equals("")){
            kunjungan.setDiterimaOleh(kunjunganParam.getDiterimaOleh());
        }

        kunjungan.setUser(kunjunganParam.getUser());

}

//    public void refreshAddKunjungan(List<Account> lsAccount //account by coveran
//                                     , List<User>  // user by coveran
//                                            lsUser) throws Exception{
//
//        Iterator<Account> itacc = lsAccount.iterator();
//        Iterator<User> ituser = lsUser.iterator();
//        Account acc = new Account();
//        User user = new User();
//        Kunjungan kunj = new Kunjungan();
//
//        while (itacc.hasNext()){
//        acc = itacc.next();
//            while (ituser.hasNext()){
//                user = ituser.next();
//
//
//
//
//
//            }
//
//
//
//            itacc.next();
//        }
//
////        List<Kunjungan> lsKunjungan
//
//
////        kunrepo.save(kunjungan);
//    }










}
