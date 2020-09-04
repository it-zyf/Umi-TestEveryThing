package com.example.xyy.test.service;

import com.example.xyy.test.bean.Login;

import java.util.List;
import java.util.Map;

public interface RegisterService {
    public void register(Map map);

    List<Login> findUserMail();

    List<Login> findTestByDynamic();
}
