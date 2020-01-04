package com.leetcode.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yun zhi fei
 * @create 2019-12-29 9:25 上午
 **/
public class TreePath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        ArrayList<String> stringArrayList = new ArrayList<>();
        getPath(root, new StringBuilder(), stringArrayList);
        System.out.println("stringArrayList = " + stringArrayList);
    }

    static void getPath(TreeNode root, StringBuilder stringBuilder, List<String> result) {
        if (root == null) {
            return;
        }
        stringBuilder.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(stringBuilder.toString());
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return;
        }
        getPath(root.left, stringBuilder, result);
        getPath(root.right, stringBuilder, result);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
}
