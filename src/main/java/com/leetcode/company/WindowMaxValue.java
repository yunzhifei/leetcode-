package com.leetcode.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yun zhi fei
 * @create 2020-01-05 11:41 上午
 **/
public class WindowMaxValue {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println("ints = " + ints);
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] res = new int[nums.length];

        List<Integer> queue = new LinkedList<>();


        for (int i = 0; i < nums.length; i++) {

            while (queue.size() > 0 && i - queue.get(0) > k - 1) {
                queue.remove(0);
            }

            while (queue.size() > 0 && nums[queue.get(0)] < nums[i]) {
                queue.remove(0);
            }

            while (queue.size() > 0 && nums[queue.get(queue.size() - 1)] < nums[i]) {
                queue.remove(queue.size() - 1);
            }
            queue.add(i);
            res[i] = nums[queue.get(0)];
        }


        return Arrays.copyOfRange(res, k - 1, res.length);
    }
}
