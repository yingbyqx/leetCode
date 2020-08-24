package com.ying;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest2 {


    private static int state = 0;

    public static void main(String[] args) {//ALIBABA
        final Lock l = new ReentrantLock();

        Thread A = new Thread(new Runnable(){
            @Override
            public void run() {
                while (state<=100) {
                    l.lock();
                    if(state%7==0 || state%7==4 || state%7==6){
                        System.out.print("A");
                        state ++;
                    }
                    l.unlock();
                }
            }
        });
        Thread B = new Thread(new Runnable(){
            @Override
            public void run() {
                while (state<=100) {
                    l.lock();
                    if( state%7==1){
                        System.out.print("L");
                        state ++;
                    }
                    l.unlock();
                }
            }
        });
        Thread C = new Thread(new Runnable(){
            @Override
            public void run() {
                while (state<=100) {
                    l.lock();
                    if( state%7==2){
                        System.out.print("I");
                        state ++;
                    }
                    l.unlock();
                }
            }
        });

        Thread D = new Thread(new Runnable(){
            @Override
            public void run() {
                while (state<=100) {
                    l.lock();
                    if(state%7==3 || state%7==5){
                        System.out.print("B");
                        state ++;
                    }
                    l.unlock();
                }
            }
        });
        A.start();
        B.start();
        C.start();
        D.start();
    }

}
