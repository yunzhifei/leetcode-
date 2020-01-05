package com.leetcode.company;

/**
 * @author yun zhi fei
 * @create 2020-01-04 10:52 下午
 **/
public class EggDrop {

    public static void main(String[] args) {
            superEggDrop(5,100);
    }

    public static int superEggDrop(int K, int N) {

        int log = log2N(N) + 1;
        if (K >= log) {
            return log;
        }

        int[] dp = new int[K];

        int res = 0;
        while (true) {
            res++;
            int pre = 0;
            for (int i = 0; i < K; i++) {
                int temp = dp[i];
                dp[i] = dp[i] + pre + 1;
                pre = temp;
                if (dp[i] >= N) {
                    return res;
                }
            }
        }
    }

    static int log2N(int n) {
        int res = -1;
        while (n != 0) {
            res++;
            n = n >>> 1;
        }
        return res;
    }
}
