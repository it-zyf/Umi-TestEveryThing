package com.example.xyy.test.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.xyy.mapper.RegisterMapper;
import com.example.xyy.test.bean.Login;
import com.example.xyy.test.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
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
            String mail=(String)map.get("邮箱");
             registerMapper.insert(userName,passWord,mail);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Login> findUserMail() {
        List<Login> userMail = registerMapper.findUserMail();
        if(CollUtil.isNotEmpty(userMail)){
            registerMapper.delete();
        }
        return userMail;
    }

    @Override
    @DS("slave_1")
    public List<Login> findTestByDynamic() {
        return registerMapper.findUserMail();
    }
}
