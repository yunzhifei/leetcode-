package com.leetcode.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yun zhi fei
 * @create 2019-12-21 6:29 下午
 **/
public class AfterOrderTree {

    public static void main(String[] args) {
        System.out.println("args = " + !true);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rest = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();


        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                rest.add(0, root.val);
                stack.push(root);
                root = root.right;
            }
            TreeNode pop = stack.pop();
            root = pop.left;
        }
        return rest;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> reslut = new ArrayList<List<Integer>>();
        boolean right = false;
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        while (level.size() > 0) {
            List<Integer> tLevel = new ArrayList();
            int len = level.size();

            for (int i = 0; i < len; i++) {
                TreeNode head = level.get(0);
                if (right) {
                    tLevel.add(head.val);
                } else {
                    tLevel.add(0, head.val);
                }
                tLevel.add(head.val);
                level.remove(0);

                if (head.left != null) {
                    level.add(head.left);
                }
                if (head.right != null) {
                    level.add(head.right);
                }


            }
            right = !right;
            reslut.add(tLevel);
        }
        return reslut;
    }


}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
