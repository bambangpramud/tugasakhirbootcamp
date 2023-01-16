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
import com.bcafinance.dto.OrderAccountDTO;
import com.bcafinance.dto.UserDTO;
import com.bcafinance.handler.ResourceNotFoundException;
import com.bcafinance.handler.ResponseHandler;
import com.bcafinance.model.Account;
import com.bcafinance.model.Kunjungan;
import com.bcafinance.model.User;
import com.bcafinance.services.KunjunganService;
import com.bcafinance.utils.ConstantMessage;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @Autowired
    private ModelMapper modelMapper;
    @PostMapping("/v1/kunjungan")
    public ResponseEntity<Object>
    saveKunjungan(@RequestBody InputKunjunganDTO inputKunjungan) throws Exception {
        if(inputKunjungan==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        kunjunganService.addInputKunjungan(inputKunjungan);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    @GetMapping("/v1/kunjungan")
    public ResponseEntity<Object> getKunjunganById(@RequestParam Long id

    )throws Exception {



        Kunjungan kunjungan =   kunjunganService.kunjunganById(id);

        if(kunjungan != null)
        {
//            UserDTO userDTO = modelMapper.map(user,UserDTO.class);
            return new ResponseHandler().
                    generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,kunjungan,null,null);
        }
        else
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
        }

    }



}
