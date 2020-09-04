package com.example.xyy.test.controller;

import com.example.xyy.test.bean.Login;
import com.example.xyy.test.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yayu
 * @title: DynamicDatasourceTest
 * @description: TODO 多数据源测试的一个类
 * @date 2020/9/49:55
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicDatasourceTest {
    @Autowired
    private RegisterService registerService;
    @RequestMapping("data1")
    public List<Login> findAll() {
        List<Login> userMail = registerService.findTestByDynamic();
        return userMail;
    }
}
