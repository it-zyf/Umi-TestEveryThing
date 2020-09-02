package com.example.xyy.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yayu
 * @title: RedisTest
 * @description: TODO
 * @date 2020/9/117:15
 */
@RequestMapping("/redis")
@RestController
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/test")
    public void test() {
        redisTemplate.opsForSet().add("name", "xyy");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

}
