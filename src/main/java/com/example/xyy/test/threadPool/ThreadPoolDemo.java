package com.example.xyy.test.threadPool;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
    public static void main(String[] args) throws  Exception {
        long start = System.currentTimeMillis();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            strings.add(String.valueOf(i));
        }
        ExecutorService ex = Executors.newFixedThreadPool(7);
//        final Future<Integer> f1 = ex.submit(new GetSum(100));
//        final Future<Integer> f2 = ex.submit(new GetSum(200));
        ex.submit(new TreadPoolDemo1(strings));
        ex.submit(new TreadPoolDemo1(strings));
//        ex.submit(new TreadPoolDemo1(strings.subList(100,150)));
//        ex.submit(new TreadPoolDemo1(strings.subList(150,200)));
//        ex.submit(new TreadPoolDemo1(strings.subList(200,250)));
//        ex.submit(new TreadPoolDemo1(strings.subList(250,300)));
//        ex.submit(new TreadPoolDemo1(strings.subList(300,350)));
//        ex.submit(new TreadPoolDemo1(strings.subList(350,strings.size())));

//        System.out.println(f1.get());
//        System.out.println(f2.get());
        ex.shutdown();

        while (true) {
            if (ex.isTerminated()) {
                long time = System.currentTimeMillis() - start;
                System.out.println("程序结束了，总耗时：" + time + " ms(毫秒)！\n");
                break;
            }

        }

    }
}
