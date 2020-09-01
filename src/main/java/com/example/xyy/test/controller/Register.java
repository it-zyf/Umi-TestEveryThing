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

    @RequestMapping("/test")
    public void register() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("姓名", "张三");
        map.put("年龄", 19);
        map.put("账号", "curyy");
        map.put("密码", "123");
        registerService.register(map);

    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello1111";
    }

}
