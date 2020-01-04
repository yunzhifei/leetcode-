package com.leetcode.company;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yun zhi fei
 * @create 2019-12-24 9:33 下午
 **/
public class ManyThreadReenlock {


    private static volatile boolean started = false;

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        Condition condition1 = reentrantLock.newCondition();


        new Thread(() -> {


            reentrantLock.lock();
            try {
                if (!started){
                    condition1.await();
                }

                for (int i = 2; i <= 20; i += 2) {
                    System.out.println("i = " + i);
                    condition.signal();
                    condition1.await();
                }
                condition.signal();
            } catch (Exception e) {

            } finally {
                reentrantLock.unlock();
            }
        }).start();

        new Thread(() -> {
            started = true;
            reentrantLock.lock();
            try {

                for (int i = 1; i < 20; i += 2) {
                    System.out.println("i = " + i);
                    condition1.signal();
                    condition.await();
                }
                condition1.signal();
            } catch (Exception e) {

            } finally {
                reentrantLock.unlock();
            }
        }).start();



    }
}
