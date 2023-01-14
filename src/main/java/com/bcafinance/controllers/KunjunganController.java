/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 1/11/2023  3:05 PM
Last Modified on 1/11/20233:05 PM
Version 1.0
*/


package com.bcafinance.controllers;


import com.bcafinance.dto.InputKunjunganDTO;
import com.bcafinance.handler.ResourceNotFoundException;
import com.bcafinance.handler.ResponseHandler;
import com.bcafinance.model.Kunjungan;
import com.bcafinance.services.KunjunganService;
import com.bcafinance.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class KunjunganController {

    @Getter
    private KunjunganService kunjunganService;

public KunjunganController(){

}

@Autowired
public KunjunganController(KunjunganService kunjunganService){
    this.kunjunganService=kunjunganService;
}

    @PostMapping("/v1/kunjungan")
    public ResponseEntity<Object>
    saveKunjungan(@RequestBody InputKunjunganDTO inputKunjungan) throws Exception {
        if(inputKunjungan==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        kunjunganService.addInputKunjungan(inputKunjungan);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }



}
