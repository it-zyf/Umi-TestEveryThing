package com.example.xyy.test.jwt;

import com.example.xyy.test.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yayu
 * @title: ParseToken
 * @description: TODO
 * @date 2020/10/10 13:18
 */
@RestController
@RequestMapping("/test/token")
public class ParseToken {
    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping("parse")
    public void parseToken() {
        Claims claims = jwtUtil.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwic3ViIjoieHh5IiwiaWF0IjoxNjAyMzA3NzU1LCJyb2xlcyI6ImFkbWluIiwiZXhwIjoxNjAyMzA4MTE1fQ.eWLUtWrLBRUxoYIPwOal03JoDurNvPJP5QPscf5ut2g");
        String subject = claims.getSubject();
        String id = claims.getId();
        System.out.println(subject);
        System.out.println(id);

    }
}
