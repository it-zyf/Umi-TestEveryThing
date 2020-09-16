package com.example.xyy.test.threadPool;

import java.util.concurrent.Callable;

public class GetSum implements Callable<Integer> {
    private int a;

    public  GetSum(int a){
        this.a=a;
    }

    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 0; i <=a; i++) {
            sum=sum+i;
        }
        Thread.sleep(20000);
        return sum;

    }
}
