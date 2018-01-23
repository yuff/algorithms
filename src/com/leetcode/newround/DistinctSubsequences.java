package com.leetcode.newround;

public class DistinctSubsequences {
	public static void main(String[] args) {
		DistinctSubsequences ds = new DistinctSubsequences();
		System.out.println(ds.numDistinct("raabbbit", "rabit"));
	}
    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
        	return 0;
        }
        int m = s.length(), n = t.length();
        int[][] num = new int[m][n];
        char tc = t.charAt(n - 1), sc = s.charAt(m - 1);
        if (tc == sc) {
        	num[m - 1][n - 1] = 1;
        }
        for(int i = m - 2; i >= 0; i--) {
        	sc = s.charAt(i);
        	if (sc == tc) {
        		num[i][n - 1] = num[i + 1][n - 1] + 1;
        	} else {
        		num[i][n - 1] = num[i + 1][n - 1];
        	}
        }
        for(int len = 2; len <= n; len++) {
        	int j = n - len;
        	tc = t.charAt(j);
        	for(int i = m - len; i >= 0; i--) {
        		num[i][j] =  num[i + 1][j];
        		sc = s.charAt(i);
        		if (sc == tc) {
        			num[i][j] += num[i + 1][j + 1];
        		} 
        	}
        }
        return num[0][0];
    }
}
