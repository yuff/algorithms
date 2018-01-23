package com.leetcode.newround;

public class PalindromePartitioningII {
	public int minCut(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int n = s.length();
		boolean[][] isPalindrome = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			isPalindrome[i][i] = true;
		}
		int[][] cut = new int[n][n];
		for (int len = 2; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				int j = i + len - 1;
				isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
				if (len > 2) {
					isPalindrome[i][j] &= isPalindrome[i + 1][j - 1];
				}
				if (isPalindrome[i][j]) {
					cut[i][j] = 0;
				}
				else {
					int min = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int tmp = cut[i][k] + cut[k + 1][j] + 1;
						min = Math.min(tmp, min);
					}
					cut[i][j] = min;
				}
			}
		}
		return cut[0][n - 1];
	}
}
