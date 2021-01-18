package com.example.xyy.test.controller;

import com.example.xyy.entity.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    public Map receive(@RequestBody Map map) {
        List<String> list = (List<String>) map.get("ids");
        return new HashMap() {{
            put("code", 200);
        }};
    }

    @RequestMapping("/test2")
    public Map test2(R r) {
        System.out.println(r.getUser());
        MultipartFile[] multipartFiles = r.getMultipartFiles();
        if (multipartFiles.length > 0) {
            for (MultipartFile multipartFile : multipartFiles) {
                System.out.println(multipartFile.getOriginalFilename());
            }
        }
        return null;
    }
}
