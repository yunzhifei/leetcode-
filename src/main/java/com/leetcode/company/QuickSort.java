package com.leetcode.company;

/**
 * @author yun zhi fei
 * @create 2019-12-21 4:20 下午
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{1,1};
        quickSot(array, 0, array.length - 1);
        System.out.println("array = " + array);
    }

    public static void quickSot(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int paration = paration(array, left, right);
        quickSot(array, left, paration);
        quickSot(array, paration + 1, right);
    }

    public static int paration(int[] array, int left, int right) {

        int l = left;
        int r = right;

        while (l < r) {
            while (l < r && array[r] >= array[left]) {
                r--;
            }
            while (l < r && array[l] <= array[left]) {
                l++;
            }
            swap(array, l, r);
        }

        swap(array, l, left);

        return l;
    }


    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
