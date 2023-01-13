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
import com.bcafinance.handler.FormatValidation;
import com.bcafinance.handler.ResourceNotFoundException;
import com.bcafinance.model.User;
import com.bcafinance.repos.KunjunganRepo;
import com.bcafinance.repos.UserRepo;
import com.bcafinance.utils.ConstantMessage;
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

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo=userRepo;
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
        Optional<User> cBeanOptional3 = userRepo.findByMsisdn(user.getMsisdn());
        if(cBeanOptional3.isPresent())//it means if exists
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_MSISDN_UNIQ);
        }
        userRepo.save(user);
    }

    public Object loginUser(LoginDTO credential) throws Exception{
        User user = userRepo.findByUniqId(credential.getUniqId()).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL));
        if(user != null){
            if (user.getPassword().equals(credential.getPassword())){
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

        user.setModifiedBy("1");
        user.setModifiedDate(new Date());

        if(r.getCollectName() != null &&
                r.getCollectName().length()>0 &&
                !Objects.equals(user.getCollectName(),r.getCollectName()))

        {
//            Optional<Reseller> cBeanOptional = resellerRepo.findByResellerName(r.getResellerName());
//            if(cBeanOptional.isPresent())//it means if exists
//            {
//                throw new ResourceNotFoundException(ConstantMessage.WARNING_RESELLER_NAME_EXIST);
//            }
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

            FormatValidation.phoneNumberFormatValidation(user.getPhoneNumber());
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

        if(!Objects.equals(user.isActive(),r.isActive()))
        {
            user.setActive(r.isActive());
        }

        if(!Objects.equals(user.isCMS(),r.isCMS()))
        {
            user.setCMS(r.isCMS());
        }

        if(!Objects.equals(user.isMobile(),r.isMobile()))
        {
            user.setMobile(r.isMobile());
        }

        if(!Objects.equals(user.isActivated(),r.isActivated()))
        {
            user.setActivated(r.isActivated());
        }

    }

}
