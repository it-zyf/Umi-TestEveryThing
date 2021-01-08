package com.example.xyy.test;

import cn.hutool.core.date.DateUtil;
import com.example.xyy.test.utils.CardUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author yayu
 * @title: CardUtilsTest
 * @description: TODO
 * @date 2020/11/23 13:42
 */
public class CardUtilsTest {
    public static void main(String[] args) throws Exception {
        System.out.println(DateUtil.ageOfNow("19960709"));
        DateUtil.ageOfNow("1990-01-30");
        System.out.println(CardUtilsTest.strToDateFormat("20000700"));
//        Map<String, Object> carInfo = CardUtil.getCarInfo("142623199908082622");
    }


    public static String strToDateFormat(String date) throws ParseException {
        System.out.println(date.substring(date.length() - 2));
        if (date.substring(date.length() - 2).equals("00")) {
            date= date.substring(0,6)+"01";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        formatter.setLenient(false);
        Date newDate = formatter.parse(date);
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(newDate);
    }
}
