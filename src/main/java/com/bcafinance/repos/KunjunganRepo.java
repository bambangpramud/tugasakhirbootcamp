package com.bcafinance.repos;

import com.bcafinance.model.Kunjungan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface KunjunganRepo extends JpaRepository<Kunjungan,Long> {



    List<Kunjungan> findKunjungansByAgingDate(LocalDate agingDate);


}
