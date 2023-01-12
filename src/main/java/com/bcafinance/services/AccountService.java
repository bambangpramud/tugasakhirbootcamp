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

import java.util.List;

@Service
@Transactional
public class AccountService {

private AccountRepo accrepo;

@Autowired
public AccountService(AccountRepo accrepo){
    this.accrepo=accrepo;
}


    @Transactional(rollbackFor = Exception.class)
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







}
