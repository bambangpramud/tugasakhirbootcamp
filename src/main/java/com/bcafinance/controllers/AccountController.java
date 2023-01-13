/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 1/11/2023  3:05 PM
Last Modified on 1/11/20233:05 PM
Version 1.0
*/


package com.bcafinance.controllers;

import com.bcafinance.dto.OrderAccountDTO;
import com.bcafinance.dto.ReportAccountDTO;
import com.bcafinance.handler.ResourceNotFoundException;
import com.bcafinance.handler.ResponseHandler;
import com.bcafinance.model.Account;
import com.bcafinance.model.Kunjungan;
import com.bcafinance.services.AccountService;
import com.bcafinance.utils.ConstantMessage;
import com.bcafinance.utils.CsvReader;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
public class AccountController {

    @Getter
    private AccountService accountService;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping("/v1/account/upl/bat/99")
    public ResponseEntity<Object>
    uploadAccount(@Valid @RequestParam("uhuy") MultipartFile multipartFile) throws Exception {
        List<Account> acc;
        try {
            if (CsvReader.isCsv(multipartFile)) {

                acc = CsvReader.csvToAccountData(multipartFile.getInputStream());
                accountService.saveBulkAccount(multipartFile);

            } else {
                throw new ResourceNotFoundException(ConstantMessage.ERROR_NOT_CSV_FILE + " -- " + multipartFile.getOriginalFilename());
            }
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR_UPLOAD_CSV + multipartFile.getOriginalFilename());
        }
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE,
                HttpStatus.CREATED,null,null,null);
    }

    @GetMapping("/v1/account/for/user")
    public ResponseEntity<Object> getAccountForUser(@RequestParam String coveran

                                                    )throws Exception {




        Iterable<Account> account =   accountService.getAccountForUser(coveran);

        List<OrderAccountDTO> lsAccountDTO = modelMapper.map(account,new TypeToken<List<OrderAccountDTO>>() {}.getType());
//

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,lsAccountDTO,null,null);

    }

    @GetMapping("/v1/account/for/report")
    public ResponseEntity<Object> getAccountForReport(@RequestParam String coveran
                                                      ,@RequestParam String agingdate

    )throws Exception {




        Iterable<Account> account =   accountService.getReportAccount(agingdate, coveran);

        List<ReportAccountDTO> lsAccountDTO = modelMapper.map(account,new TypeToken<List<ReportAccountDTO>>() {}.getType());
//

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,lsAccountDTO,null,null);

    }

    @GetMapping("/v1/account/for/report/all")
    public ResponseEntity<Object> getAccountForReportAll(


    )throws Exception {




        Iterable<Account> account =   accountService.getAccountReportAll();

        List<ReportAccountDTO> lsAccountDTO = modelMapper.map(account,new TypeToken<List<ReportAccountDTO>>() {}.getType());
//

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,lsAccountDTO,null,null);

    }
    @GetMapping("/v1/account/for/user/detail")
    public ResponseEntity<Object> getAccountDetailForUser(@RequestParam String accountNumber


    )throws Exception {




        Account account =   accountService.getAccountDetailForUser(accountNumber);



        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,account,null,null);

    }

    @PutMapping("/v1/account/upd/inputkunjungan")
    public ResponseEntity<Object> updateAccountInputKunjungan(@RequestBody Account account)throws Exception{
        accountService.updateInputKunjungan(account);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,"",null,null);
    }















}
