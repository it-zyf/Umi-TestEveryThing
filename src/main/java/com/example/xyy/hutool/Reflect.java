package com.example.xyy.hutool;


import cn.hutool.core.util.ReflectUtil;
import com.example.xyy.test.controller.Register;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author yayu
 * @title: ReflectUtil
 * @description: TODO 工具类中反射方法的运用.
 * @date 2020/8/1110:34
 */
public class Reflect {
    @Test
    public void test() {
        Method[] methods = ReflectUtil.getMethods(Register.class);
        for (Method method : methods) {
            System.out.println(method);
        }
    }


    @Test
    public void test1() {
        Method method = ReflectUtil.getMethod(Register.class, "hello");
        System.out.println(method);
    }

    //反射创建对象
    @Test
    public void test2() {
        Register register = ReflectUtil.newInstance(Register.class);
        String hello = register.hello();
        System.out.println(hello);

    }

    //创建对象执行方法

    /**
     * 最后用最简单的描述来区分new关键字和newInstance()方法的区别：
     *
     * newInstance: 弱类型。低效率。只能调用无参构造。(工厂模式的运用,降低耦合)
     *
     * new: 强类型。相对高效。能调用任何public构造。
     */
    @Test
    public void test3() {
        Register register = ReflectUtil.newInstance(Register.class);
        String hello = ReflectUtil.invoke(register, "hello");
        System.out.println(hello);
    }


}
