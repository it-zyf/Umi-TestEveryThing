package com.example.xyy.test.utils;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yayu
 * @title: DateUtil
 * @description: TODO
 * @date 2020/11/27 13:46
 */
public class MyDateUtil {
    public static Double getMonths(String startTime, String endTime) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime start = formatter.parseDateTime(startTime);
        DateTime end = formatter.parseDateTime(endTime);
        int months = Months.monthsBetween(start, end).getMonths();
        return Double.valueOf(months);
    }

    //获取月份
    public static int getMonths2(String startTime, String endTime) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM");
        DateTime start = formatter.parseDateTime(startTime);
        DateTime end = formatter.parseDateTime(endTime);
        int months = Months.monthsBetween(start, end).getMonths();
        return months;
    }

    public static List<String> findDates(Date dBegin, Date dEnd){
        List<String> lDate = new ArrayList<String>();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM");
        lDate.add(sd.format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime()))
        {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(sd.format(calBegin.getTime()));
        }
        return lDate.stream().distinct().collect(Collectors.toList());
    }

}
