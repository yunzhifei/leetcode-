package com.leetcode.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yun zhi fei
 * @create 2019-12-24 9:41 下午
 **/
public class LockSuuport {
    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        nextInteger(arrayList);
    }

    static List<Integer> nextInteger(List<Integer> nowList) {
        List<Integer> list = new LinkedList<>();

        int len = nowList.size() - 1;
        int j = nowList.size() - 1;

        while (len > 0 && nowList.get(len) <= nowList.get(len - 1)) {
            len--;
        }
        len--;
        if (len == 0) {
            Collections.reverse(nowList);
            return nowList;
        }
        while (nowList.get(j) <= nowList.get(len)) {
            j++;
        }
        swap(nowList, j, len);
        List<Integer> integers = new ArrayList<>(nowList.subList(len+1, nowList.size()));
         Collections.reverse(integers);
        List<Integer> integers1 = nowList.subList(0, len+1);
        integers1.addAll(integers);
        return integers1;
    }

    static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}

