package com.leetcode.company;

import java.util.HashMap;
import java.util.List;

/**
 * @author yun zhi fei
 * @create 2020-01-05 9:34 上午
 **/
public class WorkBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashMap<String, Boolean> ks = new HashMap<>();
        return memWord(s, wordDict, ks);
    }

    public boolean memWord(String s, List<String> wordDict, HashMap<String, Boolean> ks) {
        if ("".equals(s)) {
            return true;
        }
        if (ks.containsKey(s)) {
            return false;
        }
        boolean res = false;
        for(int i =0; i < s.length(); i++){
            if(wordDict.contains(s.substring(0,i+1))) {
                res = res || (memWord(s.substring(i + 1), wordDict, ks));
            }

        }
        StringBuilder sb = new StringBuilder();
        return  res;

    }
}
