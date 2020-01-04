package com.leetcode.company;

/**
 * @author yun zhi fei
 * @create 2019-12-21 6:11 下午
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] arrary = new int[]{1, 3, 5, 7, 9};
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + binSrach(arrary, i));
        }
    }

    private static int binSrach(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        if (array[left] == target) {
            return left;
        }
        return -1;
    }

}
