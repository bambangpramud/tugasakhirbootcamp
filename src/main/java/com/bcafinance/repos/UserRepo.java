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
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Kunjungan,Long> {
}
