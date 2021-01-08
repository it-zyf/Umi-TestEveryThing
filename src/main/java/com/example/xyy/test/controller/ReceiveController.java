package com.example.xyy.test.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yayu
 * @title: ReceiveController
 * @description: TODO
 * @date 2020/12/29 10:06
 */
@RestController
@RequestMapping("/receive")
public class ReceiveController {
    @RequestMapping("/test")
    public Map receive(@RequestBody Map map){
        List<String> list = (List<String>) map.get("ids");
        return new HashMap(){{
            put("code",200);
        }};
    }
}
