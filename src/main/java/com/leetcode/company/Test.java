package com.leetcode.company;

import java.util.HashSet;

/**
 * @author yun zhi fei
 * @create 2019-12-30 10:31 下午
 **/
public class Test {

    public static void main(String[] args) {
        char i = 'C' ^ 32;
        System.out.println("args = " + i);
        HashSet hashSet = new HashSet();
        int[][] ps = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    }

    public int findCircleNum(int[][] M) {
        if (null == M || M.length <= 0) {
            return 0;
        }
        int res = 0;

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    res++;
                    dfs(M, i);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] array, int i) {

        for (int k = 0; k < array.length; k++) {
            if (array[i][k] == 1) {
                array[i][k] = 0;
                array[k][i] = 0;
                dfs(array, k);
            }
        }
    }


}
