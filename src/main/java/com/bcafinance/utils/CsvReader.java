/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/5/2022  10:38 AM
Last Modified on 12/5/202210:38 AM
Version 1.0
*/


package com.bcafinance.utils;

import com.bcafinance.model.Account;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvReader {

    public static boolean isCsv(MultipartFile multipartFile)
    {
        if(!ConstantMessage.CONTENT_TYPE_CSV.equals(multipartFile.getContentType()))
        {
            return false;
        }
        return true;
    }

    public static List<Account> csvToAccountData(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        CSVParser csvParser = new CSVParser(bufferedReader,
                CSVFormat.DEFAULT.withFirstRecordAsHeader().
                        withIgnoreHeaderCase().
                        withTrim()
        );
        List<Account> lsCitizens = new ArrayList<Account>();
        try {

            Iterable<CSVRecord> iterRecords = csvParser.getRecords();

            for (CSVRecord record : iterRecords) {
                Account account = new Account();
                account.setAccountNumber(record.get("accountNumber"));
                account.setName(record.get("name"));
                account.setType(record.get("type"));
                account.setStatusKunjungan(record.get("statusKunjungan"));
                account.setPriority( Boolean.parseBoolean(record.get("isPriority")));
                account.setCustomer(record.get("customer"));
                account.setSpouseName(record.get("spouseName"));
                account.setHomeAddress(record.get("homeAddress"));
                account.setKtpAddress(record.get("ktpAddress"));
                account.setMailAddress(record.get("mailAddress"));
                account.setCoveran(record.get("coveran"));
                account.setPostalCode(Integer.valueOf(record.get("postalCode")));
                account.setPhoneNumber1(record.get("phoneNumber1"));
                account.setPhoneNumber2(record.get("phoneNumber2"));
                account.setAgingDate(LocalDate.parse(record.get("agingDate")));
                account.setCreatedBy(record.get("createdBy"));
                account.setCreatedDate(new Date() );



                lsCitizens.add(account);
            }

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {

            if (!csvParser.isClosed()) {
                csvParser.close();
            }
            return lsCitizens;
        }
    }


}
