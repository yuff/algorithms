package com.leetcode.mytest;

public class LongestPalindromicSubsquence {
	public static void main(String[] args) {
		LongestPalindromicSubsquence lps = new LongestPalindromicSubsquence();
		System.out.println(lps.longestPalindromeSubseq("bbbab"));
	}
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        int n = s.length();
        char[] c1 = s.toCharArray();
        char[] c2 = new char[n];
        int i = n-1;
        for(char c: c1) {
        	c2[i--] = c;
        }
        return lcs(c1,c2);
    }
    private int lcs(char[] c1, char[] c2) {
    	int n = c1.length;
    	int[][] lens = new int[n+1][n+1];
    	for(int i = 0; i <= n; i++) {
    		lens[i][0] = 0;
    		lens[0][i] = 0;
    	}
    	for(int i = 1; i <= n; i++) {
    		for(int j = 1; j <= n; j++) {
    			if (c1[i - 1] == c2[j - 1]) {
    				lens[i][j] = lens[i-1][j-1] + 1;
    			} else {
    				lens[i][j] = Math.max(lens[i][j-1], lens[i-1][j]);
    			}
    		}
    	}
    	return lens[n][n];
    }
}
