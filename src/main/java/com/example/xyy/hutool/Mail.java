package com.example.xyy.hutool;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailUtil;
import org.junit.Test;

/**
 * @author yayu
 * @title: Mail
 * @description: TODO 用hutool工具类发送邮件.easy !!!
 * @date 2020/8/2416:14
 */
public class Mail {
    @Test
    public void test() {
        MailUtil.send("15735653659@163.com", "测试", "邮件来自Hutool测试", false);
    }

    @Test
    public void test2() {
        MailUtil.send("1457937239@qq.com", "小亚亚", "<h1>欢迎来到小亚亚Time,PLEASE CONTINUE</h1>", true, FileUtil.file("P:\\hello.txt"));

    }



}
