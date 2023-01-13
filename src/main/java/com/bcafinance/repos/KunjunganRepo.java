package com.bcafinance.repos;

import com.bcafinance.model.Kunjungan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface KunjunganRepo extends JpaRepository<Kunjungan,Long> {



    List<Kunjungan> findKunjungansByAgingDate(LocalDate agingDate);

//    @Query(
//            value =
//                    "SELECT * from Kunjungan JOIN Users on Kunjungan.UserID = Users.UserID where Kunjungan.AgingDate  = :agingDate and Users.Coveran =:coveran",
//            nativeQuery = true)
//    List<Kunjungan> getReportKunjungan(@Param("agingDate") String agingDate, @Param("coveran")String coveran);
//



}
