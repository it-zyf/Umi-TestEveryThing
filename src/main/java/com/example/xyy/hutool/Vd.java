package com.example.xyy.hutool;

import cn.hutool.core.lang.Validator;
import org.junit.Test;

/**
 * @author yayu
 * @title: Validator
 * @description: TODO 字段验证器
 * @date 2020/8/2413:59
 */
public class Vd {
    @Test
    public void test(){
        java.text.NumberFormat percentFormat = java.text.NumberFormat.getPercentInstance();
        boolean isEmail = Validator.isEmail("loolly@gmail.com");
        //todo 验证是钱吗
        boolean money = Validator.isMoney("123211.2313");
        //todo 验证字符串长度12位
        boolean zhangyafeng = Validator.isMatchRegex("^.{0,12}$", "zhangyafengqw");
//        System.out.println(zhangyafeng);
        boolean mactchRegex = Validator.isMactchRegex("\\d{4}-\\d{2}-\\d{2}", "2020/09/08");

        boolean sss = Validator.isNumber("1232.21312");


        String format = percentFormat.format("0.06");

    }
}
