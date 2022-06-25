package com.laptrinhjavaweb.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String toDate(Date date) {
        return date != null ? new SimpleDateFormat("dd/MM/yyyy").format(date)
                            : new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

//    Date date = new Date();
//    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//    String strDate = formatter.format(date);
//        System.out.println(strDate);
}
