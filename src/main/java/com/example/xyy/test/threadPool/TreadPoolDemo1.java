package com.example.xyy.test.threadPool;

import lombok.SneakyThrows;

import java.util.List;

public class TreadPoolDemo1 implements Runnable {
    private List<String> list;

    public TreadPoolDemo1(List<String> list){
        this.list=list;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (this.list) {
            for (String o : list) {
                System.out.println(Thread.currentThread().getName() + "哈哈哈哈" + o);
                Thread.sleep(1000);
            }
        }
    }
}
