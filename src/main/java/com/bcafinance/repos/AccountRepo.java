package com.bcafinance.repos;

import com.bcafinance.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {


}
