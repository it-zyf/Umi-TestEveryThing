package com.example.xyy.test;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yayu
 * @title: TestController
 * @description: TODO
 * @date 2020/11/30 16:36
 */
@RequestMapping("/tets")
@RestController
public class TestController {
    @RequestMapping("/hhh")
    public void test(@RequestBody HHH h) {

    }
}
