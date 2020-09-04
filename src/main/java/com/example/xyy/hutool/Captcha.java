package com.example.xyy.hutool;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yayu
 * @title: Captcha
 * @description: TODO 图片验证码生成.
 * @date 2020/9/416:19
 */
@RestController
@RequestMapping("/captcha")
public class Captcha {
    @RequestMapping("/test")
    public void test(HttpServletResponse response) throws IOException {
        //定义图形验证码的长和宽
        ICaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        //图形验证码写出，可以写出到文件，也可以写出到流
//        lineCaptcha.write("p:/line.png");
        ServletOutputStream out = response.getOutputStream();
        lineCaptcha.write(out);
        out.close();

    }

}
