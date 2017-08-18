package com.leetcode.mytest;

public class DeleteOperationForTwoStrings {
	public static void main(String[] args) {
		DeleteOperationForTwoStrings dof = new DeleteOperationForTwoStrings();
		System.out.println(dof.minDistance("sea", "eat"));
	}

	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null) {
			return 0;
		}
		else if (word1 == null || word1.length() == 0) {
			return word2.length();
		}
		else if (word2 == null || word2.length() == 0) {
			return word1.length();
		}
		int m = word1.length();
		int n = word2.length();
		int[][] maxsub = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			maxsub[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			maxsub[0][i] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					maxsub[i][j] = 1 + maxsub[i - 1][j - 1];
				} else {
					int a = maxsub[i][j-1];
					int b = maxsub[i-1][j];
					maxsub[i][j] = Math.max(a, b);
				}
			}
		}
		return m - maxsub[m][n] + n - maxsub[m][n];

	}
}
