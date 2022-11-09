package com.transaction.transactionservice.constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Constants {

    public static String getCurrentDateTime() {
        System.out.println("Constant1");

        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate=dateFormat.format(date);
        System.out.println("Constant2");
        return formattedDate;
    }
}
