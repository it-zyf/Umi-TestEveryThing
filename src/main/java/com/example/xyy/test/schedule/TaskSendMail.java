package com.example.xyy.test.schedule;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailUtil;
import com.example.xyy.test.bean.Login;
import com.example.xyy.test.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yayu
 * @title: TaskSendMail
 * @description: TODO 定时任务,定时查询数据库发送邮件.
 * @date 2020/9/217:17
 */
@Component
public class TaskSendMail {
    @Autowired
    private RegisterService registerService;

//    @Scheduled(cron = "*/5 * * * * ?")
    public void taskSendMail() {
        List<Login> userMail = registerService.findUserMail();
        if (CollUtil.isNotEmpty(userMail)) {
            for (Login login : userMail) {
                if (StrUtil.isNotBlank(login.getMail())) {
                    MailUtil.send(login.getMail(), login.getUserName(), "<h1>欢迎来到小亚亚Time,PLEASE CONTINUE</h1>", true, FileUtil.file("P:\\hello.txt"));
                }
            }
        }
    }
}
