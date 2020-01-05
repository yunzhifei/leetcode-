package com.leetcode.company;

/**
 * @author yun zhi fei
 * @create 2020-01-05 8:50 上午
 **/
public class Char {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println("palindrome = " + palindrome);
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();

        while (left < right) {
            while (!(s.charAt(left) <= 'z' && s.charAt(left) >= 'a' ||
                    s.charAt(left) >= '0' && s.charAt(left) <= '9')) {
                left++;
            }

            while (!(s.charAt(right) <= 'z' && s.charAt(right) >= 'a' ||
                    s.charAt(right) >= '0' && s.charAt(right) <= '9')) {
                right--;
            }
            char leftchar = s.charAt(left);
            char rightchar = s.charAt(right);


            if (leftchar == rightchar) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
