package com.bcafinance.repos;

import com.bcafinance.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public interface AccountRepo extends JpaRepository<Account,Long> {


    List<Account> searchAccountByIsPriority( boolean priority);
}
