package com.leetcode.company;

import java.util.HashMap;

/**
 * @author yun zhi fei
 * @create 2020-01-01 6:03 下午
 * 字符串的排列
 **/
public class PString {
    public static void main(String[] args) {

    }


    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1CharCountMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1CharCountMap.put(c, s1CharCountMap.getOrDefault(c, 0) + 1);
        }
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> s2CharCountMap = new HashMap<>();
        while (end < s2.length()) {
            char endChar = s2.charAt(end);
            s2CharCountMap.put(s2.charAt(end), s2CharCountMap.getOrDefault(s2.charAt(end), 0) + 1);
            end++;
            while (s2CharCountMap.get(endChar) > s1CharCountMap.getOrDefault(endChar, 0)) {
                char startchar = s2.charAt(start);
                s2CharCountMap.put(startchar, s2CharCountMap.getOrDefault(startchar, 0) - 1);
                start++;
            }
            if (end - start == s1.length()) {
                return true;
            }
        }
        return false;
    }


    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> keyMap = new HashMap();

        int start = 0;
        int end = 0;
        int res = 0;
        while (end < s.length()) {
            if (keyMap.containsKey(s.charAt(end))) {
                start = Math.max(start,keyMap.get(s.charAt(end)) + 1);
            }
            keyMap.put(s.charAt(end), end);
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }

}
