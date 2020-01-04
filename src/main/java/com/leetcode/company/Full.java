package com.leetcode.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yun zhi fei
 * @create 2020-01-01 1:45 下午
 * 全排列
 **/
public class Full {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        List<List<Integer>> res = new ArrayList<>();
        dfs(array, new ArrayList<>(), res);
        System.out.println("res = " + res);
    }

    public static void dfs(int[] array, List<Integer> temp, List<List<Integer>> res) {

        if (temp.size() == array.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (temp.contains(array[i])) {
                continue;
            }
            temp.add(array[i]);
            dfs(array, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
