package com.inter12.pinellia.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA. User: inter12 Date: 5/30/13 Time: 11:20 AM To change this template use File | Settings |
 * File Templates.
 */
public class DateUtils {

    private final static String DIAN_PING_CREATE_DATE = "2003-04-01 00:00:00";

    public static Date getBegin() {
        String format = "yyyy-MM-dd HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            Date beginDate = dateFormat.parse(DIAN_PING_CREATE_DATE);
            return beginDate;
        } catch (ParseException e) {

        }
        return new Date();
    }

    public static Date getBeforeNow(int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - num,
                     calendar.get(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    public static void main(String[] args) {
        Date beforeNow = DateUtils.getBeforeNow(6);
        System.out.println(beforeNow);
    }
}
