package com.example.xyy.hutool;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailUtil;
import org.junit.Test;

/**
 * @author yayu
 * @title: Mail
 * @description: TODO
 * @date 2020/8/2416:14
 */
public class Mail {
    @Test
    public  void test(){
        MailUtil.send("15735653659@163.com", "测试", "邮件来自Hutool测试", false);
    }
}
