package com.example.xyy.test.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yayu
 * @title: Test
 * @description: TODO
 * @date 2020/11/5 15:34
 */
public class Test {
    @org.junit.Test
    public void test() throws ParseException {
        System.out.println(Test.strToDateFormat("20050100"));

    }

    public static String strToDateFormat(String date) throws ParseException {
        if (date.substring(date.length() - 2).equals("00")) {
           date= date.replace(date.substring(date.length() - 2), "01");
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        formatter.setLenient(false);
        Date newDate = formatter.parse(date);
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(newDate);
    }
}
