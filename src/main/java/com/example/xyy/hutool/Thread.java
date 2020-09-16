package com.example.xyy.hutool;

import cn.hutool.core.thread.ThreadUtil;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.Future;

/**
 * @author yayu
 * @title: thread
 * @description: TODO hutool工具类实现异步编程,没有发现好处...
 * @date 2020/9/1610:01
 */
public class Thread {
    @Test
    public void test() {
        ThreadUtil.execAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("hahah");
                ThreadUtil.sleep(6000);
            }
        }, true);
        System.out.println("123");
    }

    @Test
    public void test2() throws Exception {
        long start = System.currentTimeMillis();
        CompletionService<Object> objectCompletionService = ThreadUtil.newCompletionService();
        Callable mycallable = () -> {
            System.out.println(123);
            ThreadUtil.sleep(5000);
            return "插入成功!";
        };

        Callable callable = () -> {
            System.out.println(99999);
            ThreadUtil.sleep(10000);
            System.out.println(666);
            return "测试结果怎么样啊....";
        };
        Future submit = objectCompletionService.submit(mycallable);
        Future submit1 = objectCompletionService.submit(callable);
        Future<Object> take = objectCompletionService.take();
        Object o = take.get();
        long time = System.currentTimeMillis() - start;
        System.out.println("程序结束了，总耗时：" + time + " ms(毫秒)！\n");
        System.out.println(o.toString());

    }


}
