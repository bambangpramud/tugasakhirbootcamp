package com.bcafinance.handler;
import com.bcafinance.utils.ConstantMessage;

import java.util.regex.Pattern;

public class FormatValidation {

    public static void emailFormatValidation(String email) throws Exception
    {
        if(!(Pattern.compile(ConstantMessage.REGEX_EMAIL_STANDARD_RFC5322)
                .matcher(email)
                .matches()))
        {
            throw new ResourceNotFoundException(ConstantMessage.ERROR_EMAIL_FORMAT_INVALID);

        }
    }

    public static void phoneNumberFormatValidation(String phoneNumner) throws Exception
    {
        if(!(Pattern.compile(ConstantMessage.REGEX_PHONE)
                .matcher(phoneNumner)
                .matches()))
        {
            throw new ResourceNotFoundException(ConstantMessage.ERROR_PHONE_NUMBER_FORMAT_INVALID);
        }
    }

    public static void dateFormatYYYYMMDDValidation(String date) throws Exception
    {
        if(!(Pattern.compile(ConstantMessage.REGEX_DATE_YYYYMMDD)
                .matcher(date)
                .matches()))
        {
            throw new ResourceNotFoundException(ConstantMessage.ERROR_DATE_FORMAT_YYYYMMDD);
        }
//        REGEX_DATE_YYYYMMDD
    }

    public static void stateCodeValidation(String stateCode) throws Exception{
        if(!(stateCode.length()>1&&stateCode.length()<5))
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_CODE_INVALID);
        }
    }

    public static void noRussiaValidation(String stateName) throws Exception{
        if(!(!stateName.contains("Russia")&&!stateName.contains("russia")))
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_CODE_INVALID);
        }
    }
}
