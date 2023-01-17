/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 1/11/2023  11:53 AM
Last Modified on 1/11/202311:53 AM
Version 1.0
*/


package com.bcafinance.services;

import com.bcafinance.model.Account;
import com.bcafinance.repos.AccountRepo;
import com.bcafinance.utils.CsvReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class AccountService {

private AccountRepo accrepo;

@Autowired
public AccountService(AccountRepo accrepo){
    this.accrepo=accrepo;
}


//    @Transactional(rollbackFor = Exception.class)
    public List<Account> saveBulkAccount(MultipartFile multipartFile) throws Exception
    {
        try{
            List<Account> lsAccount = CsvReader.csvToAccountData(multipartFile.getInputStream());

            return accrepo.saveAll(lsAccount);
        }catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }

    public List<Account> getReportAccount (String agingDate,String coveran){
//        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD-MM-yyyy");


        return accrepo.searchAccountsByAgingDateAndCoveranAndStatusKunjungan(LocalDate.parse(agingDate),coveran,"pending");
    }

    public List<Account> getAccountForUser(String coveran){
    return accrepo.searchAccountsByCoveranAndStatusKunjunganIgnoreCase(coveran,"pending");
    }

    public List<Account> getAccountForUserDelivered(String coveran){
        return accrepo.searchAccountsByCoveranAndStatusKunjunganIgnoreCase(coveran,"delivered");
    }
    public Account getAccountDetailForUser(String coveran){
        return accrepo.getAccountByAccountNumber(coveran);
    }

    public long getOrderCount(String coveran){
        return accrepo.getOrderCount(coveran);
    }
    public long getSendCount(String coveran){
        return accrepo.getSendCount(coveran);
    }

    public void updateInputKunjungan(Account accountParam){

    Account account = accrepo.getAccountByAccountNumber(accountParam.getAccountNumber());

    account.setModifiedBy(accountParam.getModifiedBy());
    account.setModifiedDate(new Date());
        if (accountParam.getMailAddress()!=null
                && !Objects.equals(accountParam.getMailAddress(),account.getMailAddress())
                && !accountParam.getMailAddress().equals("")){
            account.setMailAddress(accountParam.getMailAddress());
        }

        if (accountParam.getPhoneNumber1()!=null
                && !Objects.equals(accountParam.getPhoneNumber1(),account.getPhoneNumber1())
                && !accountParam.getPhoneNumber1().equals("")){
            account.setPhoneNumber1(accountParam.getPhoneNumber1());
        }
        if (accountParam.getPhoneNumber2()!=null
                && !Objects.equals(accountParam.getPhoneNumber2(),account.getPhoneNumber2())
                && !accountParam.getPhoneNumber2().equals("")){
            account.setPhoneNumber2(accountParam.getPhoneNumber2());
        }



       account.setStatusKunjungan("delivered");

    }

    public List<Account> getAccountReportAll(){
    return accrepo.getAccountsByStatusKunjungan("pending");
    }


















}
