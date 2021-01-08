package com.example.xyy.test.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yayu
 * @title: Serialnumber
 * @description: TODO
 * @date 2020/12/16 16:18
 */
public class Serialnumber {


    public static String getXX(String xx, Integer id) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Date date = new Date();//获得当前当前时间

        if (id == null) {
            return xx + "-" + sdf.format(date) + "-" + 1;

        } else {

            return xx + "-" + sdf.format(date) + "-" + (id + 1);

        }
    }
}
