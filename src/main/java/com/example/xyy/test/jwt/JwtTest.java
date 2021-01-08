package com.example.xyy.test.jwt;

import com.example.xyy.test.utils.JwtUtil;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RestController
@RequestMapping("/test/token")
public class JwtTest {
    @Autowired
    private JwtUtil jwtUtil;

    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("123") //设置id
                .setSubject("小亚亚")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "3witxyy123");
        System.out.println(jwtBuilder.compact());

    }

    @RequestMapping("/create")
    public void test(){
        String jwt = jwtUtil.createJWT("1", "xxy", "admin");
        System.out.println(jwt);
    }
}
