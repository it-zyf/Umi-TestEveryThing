package com.example.xyy.hutool;

import cn.hutool.core.io.resource.ResourceUtil;
import org.junit.Test;

/**
 * @author yayu
 * @title: resources
 * @description: TODO 搜索资源目录
 * @date 2020/9/213:22
 */
public class ResourcesT {
    @Test
    public void test(){
        String str = ResourceUtil.readUtf8Str("P:\\learnProject\\Umi-TestEveryThing\\src\\main\\resources\\application.yml");
        System.out.println(str);

    }
}
