package com.example.xyy.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;

/**
 * @author yayu
 * @title: QrTest
 * @description: TODO 二维码生成工具
 * @date 2020/9/2210:59
 */
@RestController
@RequestMapping("/qr")
public class QrTest {
    @Test
    public void test() {
        QrCodeUtil.generate("http://150.109.235.95:8080/logQuerySystem/HTMLpage/login.html", 300, 300, FileUtil.file("G:/qrcode.jpg"));
    }

    @RequestMapping("/test")
    public void test2(HttpServletResponse response) throws Exception {
        QrConfig config = new QrConfig(300, 300);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 设置前景色，既二维码颜色（青色）
        config.setForeColor(Color.CYAN.getRGB());
        // 设置背景色（灰色）
        config.setBackColor(Color.GRAY.getRGB());
        // 生成二维码到文件，也可以到流
//        QrCodeUtil.generate("http://150.109.235.95:8080/logQuerySystem/HTMLpage/login.html", config, "image/png",response.getOutputStream());
        byte[] bytes = QrCodeUtil.generatePng("http://150.109.235.95:8080/logQuerySystem/HTMLpage/login.html", config);
        response.setContentType("image/png");
        ServletOutputStream out = response.getOutputStream();
        out.write(bytes);
        out.flush();
        out.close();


    }
}
