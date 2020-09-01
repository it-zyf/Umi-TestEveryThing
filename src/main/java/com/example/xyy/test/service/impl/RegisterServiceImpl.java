package com.example.xyy.test.service.impl;

import com.example.xyy.mapper.RegisterMapper;
import com.example.xyy.test.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void register(Map map) {
        String userName = null;
        try {
            userName = (String) map.get("账号");
            //对密码进行加密
            String passWord = encoder.encode((String)map.get("密码"));
             registerMapper.insert(userName,passWord);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
