package com.example.xyy.test.utils;
import javax.xml.bind.SchemaOutputResolver;
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

    @org.junit.Test
    public void test2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyMMddHHmmss");
        String format = sdf.format(new Date());
        System.out.println(format);

        String a="abc.jpg";
        String split = a.split("\\.")[1];
        System.out.println(split);
    }
    @org.junit.Test
    public  void test3(){
        String s = Test.formatNum(23, 3);
        System.out.println(s);
    }
    private static  String formatNum(int sxh, int digit)  {
        String temp = "000000000000000";
        String sxhStr = String.valueOf(sxh);
        int num = digit - sxhStr.length();
        if (num < 0) {
            System.out.println("顺序号位数超长");
        }
        return temp.substring(0, num) + sxh;
    }
}
