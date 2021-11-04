package com.ying;

import com.alibaba.fastjson.JSON;

public  class ThreadYing implements Runnable{
    private int[] num;
    private int index;
    private int step;
    private int resultIndex;
    private int[] resultList;

    public ThreadYing() {
    }

    public ThreadYing(int[] num, int index, int step, int[] resultList, int resultIndex) {
        this.num = num;
        this.index = index;
        this.step = step;
        this.resultIndex = resultIndex;
        this.resultList = resultList;
    }

    @Override
    public void run() {
        int result = 0;
        for (int i = index; i < index + step; i++) {
            result += num[i];
        }
        resultList[resultIndex] = result;
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] a = new int[2];
        a[0] = 1;
        getA(a);
        System.out.println(JSON.toJSONString(a));
    }

    private static void getA(int[] a) {
        a[0] = 2;
    }
}
