package com.example.xyy.entity;

import lombok.Data;

/**
 * @author yayu
 * @title: User
 * @description: TODO
 * @date 2020/9/2115:18
 */
@Data
public class User {
    private String name;
    private String age;
    private String sex;
    private String source;
    public User() {
    }

    public User(String name, String age, String sex, String source) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.source = source;
    }
}
