package com.bcafinance.controllers;
/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition) 
@Author ASUS a.k.a. Archan
ITDP 7
Created on 11/01/2023
@Last Modified on 11/01/2023 17:10
Version 1.0
*/

import com.bcafinance.dto.LoginDTO;
import com.bcafinance.dto.UserDTO;
import com.bcafinance.handler.ResourceNotFoundException;
import com.bcafinance.handler.ResponseHandler;
import com.bcafinance.model.User;
import com.bcafinance.services.KunjunganService;
import com.bcafinance.services.UserService;
import com.bcafinance.utils.ConstantMessage;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/")
public class UserController {
    @Getter
    private UserService userService;


    @Autowired
    private ModelMapper modelMapper;

    public UserController(){

    }

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }


    @PostMapping("/user")
    public ResponseEntity<Object>
    saveUser(@Valid @RequestBody User user, @RequestHeader Map<String,String> headers,
                 @RequestParam Map<String,String> params,
                 WebRequest request, Error error) throws Exception {
        if(user==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        userService.saveUser(user);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }


    @PostMapping("/user/login")
    public ResponseEntity<Object>
    loginUser(@Valid @RequestBody LoginDTO user, @RequestHeader Map<String,String> headers,
              @RequestParam Map<String,String> params,
              WebRequest request, Error error) throws Exception {
        if(user==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_LOGIN, HttpStatus.OK,modelMapper.map(userService.loginUser(user),UserDTO.class),null,null);
    }


    @GetMapping("/user/all")
    public ResponseEntity<Object> findAllUserDTO()throws Exception{

        List<User> lsUser = userService.findAllUser();

        if(lsUser.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        List<UserDTO> lsUserDTO = modelMapper.map(lsUser, new TypeToken<List<UserDTO>>() {}.getType());

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsUserDTO,null,null);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Object> findUserById(@PathVariable("id") Long id)throws Exception{

        User user = userService.findUserById(id);

        if(user != null)
        {
            UserDTO userDTO = modelMapper.map(user,UserDTO.class);
            return new ResponseHandler().
                    generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,userDTO,null,null);
        }
        else
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
        }

    }
    @PutMapping("/user/update")
    public ResponseEntity<Object> updateUserByID(@RequestBody User user)throws Exception{
        userService.updateUserByID(user);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,"",null,null);
    }
}
