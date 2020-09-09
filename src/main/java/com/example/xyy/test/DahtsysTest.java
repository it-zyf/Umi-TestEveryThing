package com.example.xyy.test;

import cn.hutool.core.date.DateUtil;

/**
 * @author yayu
 * @title: DahtsysTest
 * @description: TODO
 * @date 2020/9/817:10
 */
public class DahtsysTest {
    public static void main(String[] args) {
        String format = DateUtil.format(DateUtil.parse("2020/07/07"), "yyyyMMddHHmmss");
        System.out.println(format);
    }
}
