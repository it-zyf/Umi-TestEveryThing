package com.example.xyy.rateLimter;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author yayu
 * @title: RateLimter
 * @description: TODO 令牌桶算法限流
 * @date 2020/9/1513:34
 */
public class TestRateLimter {
    @Test
    public void test() {
        //1秒产生1个令牌
        final RateLimiter rateLimiter = RateLimiter.create(1);
        for (int i = 0; i < 10; i++) {
            //该方法会阻塞线程，直到令牌桶中能取到令牌为止才继续向下执行。
            double waitTime = rateLimiter.acquire();
            System.out.println("任务执行" + i + "等待时间" + waitTime);
        }
        System.out.println("执行结束");
    }

    @Test
    public void test2() {

        final RateLimiter rateLimiter = RateLimiter.create(1);

        for (int i = 0; i < 10; i++) {
            long timeOut = (long) 0.5;
            //其中用到了tryAcquire方法，这个方法的主要作用是设定一个超时的时间，
            // 如果在指定的时间内预估(注意是预估并不会真实的等待)，如果能拿到令牌就返回true，如果拿不到就返回false.
            boolean isValid = rateLimiter.tryAcquire(timeOut, TimeUnit.SECONDS);
            System.out.println("任务" + i + "执行是否有效:" + isValid);
            if (!isValid) {
                continue;
            }
            System.out.println("任务" + i + "在执行");
        }
        System.out.println("结束");
    }
}

