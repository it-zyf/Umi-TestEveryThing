package com.example.xyy.test.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.xyy.mapper.RegisterMapper;
import com.example.xyy.test.bean.Login;
import com.example.xyy.test.service.RegisterService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@DS("slave_1")
public class RegisterServiceImpl2 implements RegisterService2 {
    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public Map<String, Object> insert(Login login) {
        registerMapper.insert_login(login);
        return new HashMap<String, Object>(){{
            put("code",200);
        }};
    }


}
