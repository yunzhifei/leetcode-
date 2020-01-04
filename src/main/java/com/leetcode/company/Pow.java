package com.leetcode.company;

/**
 * @author yun zhi fei
 * @create 2020-01-04 1:10 下午
 **/
public class Pow {

    public static void main(String[] args) {
        System.out.println("args = " + qsm(2, 3, 6));
    }

    static long qsm(int q, int k, int m) {
        long res = 1;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = res * q % m;
            }
            q = q * q % m;
            k = k >> 1;
        }

        return res;
    }
}
