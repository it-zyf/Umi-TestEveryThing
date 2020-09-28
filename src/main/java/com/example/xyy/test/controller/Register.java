package com.example.xyy.test.controller;

import com.example.xyy.entity.User_R;
import com.example.xyy.test.service.RegisterService;
import com.example.xyy.test.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class Register {
    @Autowired
    private RegisterService registerService;

    @RequestMapping("/test1")
    public ResultBean register(@RequestBody User_R user) {
        registerService.register(user);
        return ResultBean.ok("添加成功");

    }

}
