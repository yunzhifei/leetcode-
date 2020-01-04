package com.leetcode.company;

/**
 * @author yun zhi fei
 * @create 2019-12-22 6:43 下午
 **/
public class Tag {

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2};

        init(array);
        System.out.println("array = " + array);
    }

    private static void init(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int cur = 0;

        while (cur <= right) {
            if (array[cur] == 0) {
                swap(array, cur, left);
                left++;
                cur++;
            } else if (array[cur] == 1) {
                cur++;
            } else {
                swap(array, cur, right);
                right--;
            }

        }
    }


    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }



}


