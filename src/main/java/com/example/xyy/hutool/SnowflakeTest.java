package com.example.xyy.hutool;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;

/**
 * @author yayu
 * @title: SnowflakeTest
 * @description: TODO
 * @date 2020/9/111:06
 */
public class SnowflakeTest {
    private final Snowflake snowflake = IdUtil.getSnowflake(1, 1);

    @Test
    public void test() {
        for (int i = 0; i < 20; i++) {
            long id = snowflake.nextId();
            System.out.println(id);
        }

    }



}
