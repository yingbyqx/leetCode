package com.ying;

import com.alibaba.fastjson.JSON;

public class ThreadTest3 {


    public static void main(String[] args) throws Exception {
        int[] num = new int[10000];
        for (int i = 0; i < 10000; i++) {
            num[i] = i;
        }

        int[] result = new  int[5];
        ThreadYing thread1 = new ThreadYing(num, 0, 2000, result, 0);
        ThreadYing thread2 = new ThreadYing(num, 2000, 2000, result, 1);
        ThreadYing thread3 = new ThreadYing(num, 4000, 2000, result, 2);
        ThreadYing thread4 = new ThreadYing(num, 6000, 2000, result, 3);
        ThreadYing thread5 = new ThreadYing(num, 8000, 2000, result, 4);

        Thread ying1 = new Thread(thread1);
        ying1.start();
        Thread ying2 = new Thread(thread2);
        ying2.start();
        Thread ying3 = new Thread(thread3);
        ying3.start();
        Thread ying4 = new Thread(thread4);
        ying4.start();
        Thread ying5 = new Thread(thread5);
        ying5.start();

        ying1.join();
        ying2.join();
        ying3.join();
        ying4.join();
        ying5.join();
        System.out.println(JSON.toJSONString(result));
    }
}
