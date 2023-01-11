/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 1/11/2023  3:05 PM
Last Modified on 1/11/20233:05 PM
Version 1.0
*/


package com.bcafinance.controllers;

import com.bcafinance.services.AccountService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class AccountController {

    @Getter
    private AccountService accountService;

    public AccountController(){

    }

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }



}
