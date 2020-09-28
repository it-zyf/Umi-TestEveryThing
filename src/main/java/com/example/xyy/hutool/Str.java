package com.example.xyy.hutool;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.Test;
import org.junit.rules.TestRule;

/**
 * @author yayu
 * @title: Str
 * @description: TODO 字符串工具-StrUtil
 * @date 2020/8/2410:04
 */
public class Str {
    //todo 判断空字符串
    @Test
    public  void test(){
        boolean notEmpty = StrUtil.isNotEmpty("123"+"");
        boolean notBlank = StrUtil.isNotBlank("123"+"");
        System.out.println(notEmpty);
        System.out.println(notBlank);
    }

    //todo 去除前缀后缀
    @Test
    public void test2(){
        String fileName = StrUtil.removeSuffix("pretty_girl.jpg", ".jpg");
        String s = StrUtil.removePrefix("xyy_123", "xyy_");
        System.out.println(fileName);
        System.out.println(s);
    }

    //todo 字符串截取.
    @Test
    public void test3(){
        String str = "abcdefgh";
        String strSub1 = StrUtil.sub(str, 2, 3); //strSub1 -> c
        String strSub2 = StrUtil.sub(str, 2, -3); //strSub2 -> cde
        String strSub3 = StrUtil.sub(str, 3, 2); //strSub2 -> c
    }

    //todo 判断是否为数字
    @Test
    public void test4(){
        boolean zyd = NumberUtil.isNumber("..12312313.12313");
        System.out.println(zyd);
    }

    @Test
    public void test5(){
        //年龄
        int i = DateUtil.ageOfNow("1996-07-09");
        System.out.println(i);
        //属相
        String chineseZodiac = DateUtil.getChineseZodiac(1996);
        System.out.println(chineseZodiac);
        //星座
        String zodiac = DateUtil.getZodiac(Month.JULY.getValue(), 9);
        System.out.println(zodiac);
    }




}
