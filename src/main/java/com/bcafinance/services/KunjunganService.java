/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 1/11/2023  11:53 AM
Last Modified on 1/11/202311:53 AM
Version 1.0
*/


package com.bcafinance.services;

import com.bcafinance.repos.KunjunganRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KunjunganService {

    private KunjunganRepo kunrepo;

    @Autowired
    public KunjunganService(KunjunganRepo kunrepo){
        this.kunrepo=kunrepo;
    }



}
