package com.example.xyy.test.controller;

import com.example.xyy.test.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/register")
public class Register {
    @Autowired
    private RegisterService registerService;

    @RequestMapping("/test1")
    public void register() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("姓名", "陈树珍");
        map.put("年龄", 19);
        map.put("邮箱","1457937239@qq.com");
        map.put("账号", "csz");
        map.put("密码", "123");
        registerService.register(map);

    }

}
