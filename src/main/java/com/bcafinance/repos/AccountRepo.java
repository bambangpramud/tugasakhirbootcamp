package com.bcafinance.repos;

import com.bcafinance.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {


    List<Account> searchAccountsByIsPriority( boolean priority);

    List<Account> searchAccountsByCoveranAndStatusKunjunganIgnoreCase(String coveran,String statusKunjungan);

    Account getAccountByAccountNumber(String accountNumber);


    List<Account> searchAccountsByAgingDateAndCoveranAndStatusKunjungan(LocalDate agingDate, String coveran,String statusKunjungan);
    List<Account> searchAccountsByCoveranAndIsPriority(String coveran,boolean isPriority);


    List<Account> getAccountsByStatusKunjungan(String statusKunjungan);

    Optional<Account> findAccountByAccountNumber(String accountNumber);



}
