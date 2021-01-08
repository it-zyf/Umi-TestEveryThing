package com.example.xyy.test;


import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author yayu
 * @title: Demo
 * @description: TODO
 * @date 2020/11/27 13:42
 */
public class Demo {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime start = formatter.parseDateTime("2017-07-11");
        DateTime end = formatter.parseDateTime("2017-11-19");
        int months = Months.monthsBetween(start, end).getMonths();
        System.out.println(months);
    }
}
