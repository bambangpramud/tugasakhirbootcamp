package com.bcafinance.services;
/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition) 
@Author ASUS a.k.a. Archan
ITDP 7
Created on 11/01/2023
@Last Modified on 11/01/2023 17:11
Version 1.0
*/
import com.bcafinance.dto.LoginDTO;
import com.bcafinance.dto.UserDTO;
import com.bcafinance.handler.FormatValidation;
import com.bcafinance.handler.ResourceNotFoundException;
import com.bcafinance.model.User;
import com.bcafinance.repos.KunjunganRepo;
import com.bcafinance.repos.UserRepo;
import com.bcafinance.utils.ConstantMessage;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private UserRepo userRepo;

    private AccountService accountService;


    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    public UserService(UserRepo userRepo,AccountService accountService){

        this.userRepo=userRepo;
        this.accountService=accountService;
    }



    public void saveUser(User user) throws Exception{

            Optional<User> cBeanOptional = userRepo.findByUniqId(user.getUniqId());
            if(cBeanOptional.isPresent())//it means if exists
            {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_UNIQ_ID_UNIQ);
            }
        Optional<User> cBeanOptional2 = userRepo.findByPhoneNumber(user.getPhoneNumber());
        if(cBeanOptional2.isPresent())//it means if exists
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_PHONE_NUMBER_UNIQ);
        }
        if (user.getCMS()==null){
            throw new ResourceNotFoundException(ConstantMessage.WARNING_CMS_REQUIRED);
        }
        if (user.getMobile()==null){
            throw new ResourceNotFoundException(ConstantMessage.WARNING_MOBILE_REQUIRED);
        }

        FormatValidation.phoneNumberFormatValidation(user.getPhoneNumber());
        user.setActive(true);
        user.setActivated(false);
        userRepo.save(user);
    }

    public Object loginUser(LoginDTO credential) throws Exception{

        User user = userRepo.findByUniqId(credential.getUniqId()).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL));
        UserDTO userDTO = modelMapper.map(user,UserDTO.class);
        if(user != null){
            if (user.getPassword().equals(credential.getPassword())){
//                userDTO.setOrderCount(accountService.getOrderCount(user.getCoveran()));
                return user;
            }
            else{
                throw  new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL);
            }
        }else{
            throw  new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL);
        }
    }

    public List<User> findAllUser()
    {
        return userRepo.getUserActive();
    }

    public User findUserById(Long id) throws Exception
    {
        return userRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
    }


    @Transactional
    public void updateUserByID(User r) throws Exception{
        User user = userRepo.findById(r.getId()).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_USER_NOT_FOUND));

        user.setModifiedBy(r.getModifiedBy());
        user.setModifiedDate(new Date());

        Optional<User> cBeanOptional = userRepo.findByUniqId(r.getUniqId());
        if(r.getUniqId() != null && !r.getUniqId().equals("")&&
                !Objects.equals(user.getUniqId(),r.getUniqId()) )
        {
            if (cBeanOptional.isPresent()){
                throw new ResourceNotFoundException(ConstantMessage.WARNING_UNIQ_ID_UNIQ);
            }
            user.setUniqId(r.getUniqId());
        }

        if(r.getCollectName() != null &&
                r.getCollectName().length()>0 &&
                !Objects.equals(user.getCollectName(),r.getCollectName()))

        {
            user.setCollectName(r.getCollectName());
        }


        if(r.getCoveran() != null
                && !Objects.equals(user.getCoveran(),r.getCoveran())
                && !r.getCoveran().equals(""))
        {
            user.setCoveran(r.getCoveran());//BERARTI ADA PERUBAHAN DI SINI
        }


        if(r.getPhoneNumber() != null &&
                r.getPhoneNumber().length()>0 &&
                !Objects.equals(user.getPhoneNumber(),r.getPhoneNumber())){

            FormatValidation.phoneNumberFormatValidation(r.getPhoneNumber());
            user.setPhoneNumber(r.getPhoneNumber());
        }

        if(r.getMsisdn() != null &&
                r.getMsisdn().length()>0 &&
                !Objects.equals(user.getMsisdn(),r.getMsisdn())){

            FormatValidation.phoneNumberFormatValidation(user.getMsisdn());
            user.setMsisdn(r.getMsisdn());
        }

        if(r.getRemark() != null
                && !Objects.equals(user.getRemark(),r.getRemark())
                && !r.getRemark().equals(""))
        {
            user.setRemark(r.getRemark());//BERARTI ADA PERUBAHAN DI SINI
        }

        if(r.getTitle() != null
                && !Objects.equals(user.getTitle(),r.getTitle())
                && !r.getTitle().equals(""))
        {
            user.setTitle(r.getTitle());//BERARTI ADA PERUBAHAN DI SINI
        }


        if(r.getType() != null
                && !Objects.equals(user.getType(),r.getType())
                && !r.getType().equals(""))
        {
            user.setType(r.getType());//BERARTI ADA PERUBAHAN DI SINI
        }

        if(r.getPassword() != null
                && !Objects.equals(user.getPassword(),r.getPassword())
                && !r.getPassword().equals(""))
        {
            user.setPassword(r.getPassword());//BERARTI ADA PERUBAHAN DI SINI
        }

        if(!Objects.equals(user.getActive(),r.getActive()) && r.getActive() != null && !r.getActive().equals(""))
        {
            user.setActive(r.getActive());
        }

        if(!Objects.equals(user.getCMS(),r.getCMS()) && r.getCMS() != null && !r.getCMS().equals(""))
        {
            user.setCMS(r.getCMS());
        }

        if(!Objects.equals(user.getMobile(),r.getMobile()) && r.getMobile() != null && !r.getMobile().equals(""))
        {
            user.setMobile(r.getMobile());
        }

        if(!Objects.equals(user.getActivated(),r.getActivated()) && r.getActivated() != null && !r.getActivated().equals(""))
        {
            user.setActivated(r.getActivated());
        }

    }

}
