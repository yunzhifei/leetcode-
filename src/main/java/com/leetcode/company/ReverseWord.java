package com.leetcode.company;

/**
 * @author yun zhi fei
 * @create 2020-01-01 5:49 下午
 **/
public class ReverseWord {

    public static void main(String[] args) {
        String s = reverseWords("");
        System.out.println("s = " + s);
    }

    public static String reverseWords(String s) {
        String trim = s.trim();
        String[] s1 = trim.split(" ");

        for (int i = 0; i < s1.length / 2; i++) {
            String temp = s1[i];
            s1[i] = s1[s1.length - 1 - i];
            s1[s1.length - 1 - i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (String s2 : s1) {
            if(s2.trim().length() !=0){
                sb.append(s2 + " ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
