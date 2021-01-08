package com.example.xyy.test.controller;

import cn.hutool.core.date.DateUtil;
import com.example.xyy.test.utils.MyDateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author yayu
 * @title: DateTest
 * @description: TODO
 * @date 2020/12/11 10:02
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        System.out.println(DateUtil.date());
        System.out.println(DateUtil.ageOfNow("1996-07-09"));
        String chineseZodiac = DateUtil.getChineseZodiac(1996);
        System.out.println(chineseZodiac);
//        long now = System.currentTimeMillis();
//        System.out.println(now);
        long now = DateUtil.date().getTime();
        System.out.println(now);
        Date date = DateUtil.parse("2021-03-01 00:00:00");
        System.out.println(date.getTime());

//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
//        Date parse = formatter.parse("2020-01");
//        Date parse1 = formatter.parse("2020-09");
//        List<String> dates = MyDateUtil.findDates(parse, parse1);
//        dates.forEach(li-> System.out.println(li));
//        String a="2019-12-08";
//        String substring1 = a.substring(8, 10);
//        System.out.println(substring1);
//        String b="2020-12";
//        if(Integer.parseInt(substring1)>15){
//            System.out.println("ni 是 住");
//        }
//        Date parse = formatter.parse(b);


//        int months2 = MyDateUtil.getMonths2(a, b);
//        System.out.println(months2);
//        String substring = a.substring(0, 7);
//        System.out.println(substring);

//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String date = "";
//        Date dt1 = formatter.parse(date);
//        Date dt2 = formatter.parse("2020-12-06");//将字符串转换为date类型
//        Date dt3 = formatter.parse("2020-12-11");
//        if (dt1.getTime() > dt2.getTime() && dt1.getTime() < dt3.getTime()) {
//            System.out.println(11111);
//            date="2020-12-11";
//        }

    }



}
