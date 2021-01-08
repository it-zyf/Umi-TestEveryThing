package com.example.xyy.test;

import com.example.xyy.test.utils.EntityTest;


import java.lang.reflect.Field;
import java.util.*;

/**
 * @author yayu
 * @title: EntityTest
 * @description: TODO
 * @date 2020/12/4 11:39
 */
public class EntityTest2 {
    public static void main(String[] args) {
        List<String> fildList=new ArrayList<>();
        HHH hhh = new HHH();
        hhh.setAge("12");
        hhh.setXm("张三");
        hhh.setNl("99");
        hhh.setSg("198");
        HHH hhh2 = new HHH();
        hhh2.setAge("12");
        hhh2.setXm("李四");
        hhh2.setNl("999");
        hhh2.setSg("1989");
        Map<String, Object> modifyContent = EntityTest.getModifyContent(hhh2, hhh);
        Object age = modifyContent.get("age");
        if(null !=age){
            fildList.add("年龄");
        }
        for (String s : fildList) {
            System.out.println(s);
        }
    }
}
