package com.leetcode.mytest;

import java.util.*;

import com.java8.util.CommonUtil;

public class WordBreakII {
	public static void main(String[] args) {
		WordBreakII wb = new WordBreakII();
		String s = "catsanddog";
		List<String> wordDict = CommonUtil.buildList(new String[]{"cat", "cats", "and", "sand", "dog"});
		System.out.println(wb.wordBreak(s, wordDict ));
	}
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
        	return new ArrayList<>();
        }
        int n = s.length();
        List[] wb = new ArrayList[n];
        for(int i = 0; i < n; i++) {
        	List<Integer> list = new ArrayList<>();
        	String cur = s.substring(0, i + 1);
        	if (wordDict.contains(cur)) {
        		list.add(0);
        	}
        	for(int j = 0; j < i; j++) {
        		if (wb[j].size() > 0) {
        			String tmp = s.substring(j + 1, i + 1);
        			if (wordDict.contains(tmp)) {
        				list.add(j + 1);
        			}
        		}
        	}
        	wb[i] = list;
        }
        List<StringBuilder> r = buildString(s, wb, n - 1);
        List<String> result = new ArrayList<>();
        for(StringBuilder b: r) {
        	result.add(b.toString());
        }
        return result;
    }

	private List<StringBuilder> buildString(String s, List[] wb, int end) {
		if (end < 0) {
			return new ArrayList<>();
		}
		List<StringBuilder> r = new ArrayList<>();
		List<Integer> list = wb[end];
		for(int i: list) {
			String t = s.substring(i, end + 1);
			List<StringBuilder> tmp = buildString(s, wb, i - 1);
			if (tmp.size() > 0) {				
				for(StringBuilder b: tmp) {
					b.append(" ");
					b.append(t);
					r.add(b);
				}
			} else {
				StringBuilder b = new StringBuilder(t);
				r.add(b);
			}
		}
		return r;
	}
    
}
