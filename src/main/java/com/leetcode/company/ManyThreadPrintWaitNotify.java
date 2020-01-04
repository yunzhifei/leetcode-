package com.leetcode.company;

/**
 * @author yun zhi fei
 * @create 2019-12-24 9:33 下午
 **/
public class ManyThreadPrintWaitNotify {


    private static volatile boolean started = false;

    public static void main(String[] args) {
        Object o = new Object();

        new Thread(() -> {
            started = true;
            int start = 1;
            for (int i = 0; i < 10; i++) {
                synchronized (o) {
                    System.out.println("start = " + start);
                    start += 2;
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {

                    }
                    o.notify();
                }
            }

        }).start();


        new Thread(() -> {
            while (!started) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int start = 2;
            for (int i = 0; i < 10; i++) {
                synchronized (o) {

                    System.out.println("start = " + start);
                    start += 2;
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    o.notify();
                }
            }
        }).start();

    }
}
