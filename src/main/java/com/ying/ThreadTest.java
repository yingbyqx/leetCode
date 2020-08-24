package com.ying;

public class ThreadTest {

    static int[] share = new int[1];
    static int count = 1;
    static boolean end = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (share) {
                    while (count <= 100) {
                        try {
                            share.notify();
                            System.out.println("thread 1 print A" );
                            share.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    end = true;

                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (share) {
                    while (count <= 100) {
                        try {
                            share.notify();
                            System.out.println("thread 2 print " + count++);
                            share.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     /*   while (end){
            thread1.stop();
            thread2.stop();
        }*/
    }
}
