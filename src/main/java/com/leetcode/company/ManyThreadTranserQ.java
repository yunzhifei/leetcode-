package com.leetcode.company;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author yun zhi fei
 * @create 2019-12-24 9:33 下午
 **/
public class ManyThreadTranserQ {


    private static volatile boolean started = false;

    public static void main(String[] args) {
        TransferQueue transferQueue = new LinkedTransferQueue();

        new Thread(() -> {
            for (int i = 1; i < 20; i += 2){
                try {
                    transferQueue.transfer(i);
                    Object take = transferQueue.take();
                    System.out.println("take = " + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {
            for (int i = 2; i <= 20; i += 2){
                try {
                    Object take = transferQueue.take();
                    System.out.println("take = " + take);
                    transferQueue.transfer(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
