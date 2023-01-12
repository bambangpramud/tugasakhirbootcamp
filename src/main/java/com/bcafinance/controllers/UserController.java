package com.bcafinance.controllers;
/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition) 
@Author ASUS a.k.a. Archan
ITDP 7
Created on 11/01/2023
@Last Modified on 11/01/2023 17:10
Version 1.0
*/

import com.bcafinance.services.KunjunganService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class UserController {
    @Getter
    private KunjunganService kunjunganService;

    public UserController(){

    }

    @Autowired
    public UserController(KunjunganService kunjunganService){
        this.kunjunganService=kunjunganService;
    }
}
