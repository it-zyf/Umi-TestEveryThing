package com.example.xyy.test.hh;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;

public class Learn {
    private static final int BEGIN_DAY = 20190731;

    public static void main(String[] args) throws ParseException {
        final long beginTime = DateUtils.parseDate(String.valueOf(BEGIN_DAY), "yyyyMMdd").getTime();
        System.out.println(beginTime);
    }



}
