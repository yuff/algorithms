package com.leetcode.mytest;

import java.util.*;

public class WordBreak {
	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		List<String> dict = new ArrayList<>();
		dict.add("leet");
		dict.add("code");
		dict.add("cat");
		dict.add("cats");
		dict.add("sand");
		dict.add("and");
		dict.add("dog");
		System.out.println(wb.wordBreak("leetcode", dict));
		System.out.println(wb.wordBreak("catsanddog", dict));
	}
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
        	return false;
        }
        int n = s.length();
        boolean[] b = new boolean[n];
        b[0] = wordDict.contains(s.substring(0, 1));
        for(int i = 0; i < n; i++) {
        	boolean tmp = wordDict.contains(s.substring(0, i + 1));
        	if (tmp) {
        		b[i] = true;
        	} else {
        		for(int j = 0; j < i; j++) {
        			if (b[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
        				b[i] = true;
        				break;
        			}
        		}
        	}
        }
        return b[n - 1];
    }
}
