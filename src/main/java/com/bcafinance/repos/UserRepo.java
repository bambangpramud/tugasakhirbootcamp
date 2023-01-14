package com.bcafinance.repos;

/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition) 
@Author ASUS a.k.a. Archan
ITDP 7
Created on 11/01/2023
@Last Modified on 11/01/2023 17:11
Version 1.0
*/

import com.bcafinance.model.Kunjungan;

import com.bcafinance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByUniqId(String uniqId);
    Optional<User> findByMsisdn(String phone);
    Optional<User> findByPhoneNumber(String phone);
    User getUserById(Long id);

    @Query(value = "SELECT * FROM users WHERE IsActive = 'true'",
            nativeQuery = true)
    @Modifying
    List<User> getUserActive();

}
