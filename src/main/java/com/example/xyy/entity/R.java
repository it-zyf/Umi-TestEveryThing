package com.example.xyy.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yayu
 * @title: R
 * @description: TODO
 * @date 2021/1/14 10:39
 */
@Data
public class R {
    private String user;
    private String age;
    private String sex;
    private MultipartFile[] multipartFiles;
}
