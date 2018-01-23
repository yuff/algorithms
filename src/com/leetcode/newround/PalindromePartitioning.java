package com.leetcode.newround;

import java.util.*;

public class PalindromePartitioning {
	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		System.out.println(pp.partition("aab"));
	}
    public List<List<String>> partition(String s) {
    	if (s == null || s.length() == 0) {
    		return new ArrayList<>();
    	}
    	int n = s.length();
    	boolean[][] isPalin = new boolean[n][n];
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j <=i; j++) {
    			if (s.charAt(i) == s.charAt(j) && (i - 1 <= j + 1 || isPalin[j + 1][i - 1])) {
    				isPalin[j][i] = true;
    			}
    		}
    	}
        return partition(s, 0, isPalin);
    }

	private List<List<String>> partition(String s, int id, boolean[][] isPalin) {
		int n = s.length();
		List<List<String>> result = new ArrayList<>();
		for(int i = id; i < n; i++) {
			if (isPalin[id][i]) {
				String str = s.substring(id, i + 1);
				List<List<String>> tmp = partition(s,i + 1, isPalin);
				List<String> r = new ArrayList<>();
				r.add(str);
				if (tmp.size() > 0) {					
					for(List<String> list: tmp) {
						List<String> t = new ArrayList<>(r);
						t.addAll(list);
						result.add(t);
					}
				} else {
					result.add(r);
				}
			}
		}
		return result;
	}
}
