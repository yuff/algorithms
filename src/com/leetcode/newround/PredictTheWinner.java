package com.leetcode.newround;

public class PredictTheWinner {
	public static void main(String[] args) {
		PredictTheWinner ptw = new PredictTheWinner();
		System.out.println(ptw.predictTheWinner(new int[] {0}));
	}

	public boolean predictTheWinner(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int n = nums.length;
		int[][] ids = new int[n][n], maxScore = new int[n][n];
		for (int i = 0; i < n; i++) {
			ids[i][i] = i;
			maxScore[i][i] = nums[i];
		}
		for (int len = 2; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				int j = len + i - 1;
				int value1 = nums[i] + (ids[i + 1][j] == i + 1 ? (i + 2 < n ? maxScore[i + 2][j] : 0)
				                                              : maxScore[i + 1][j - 1]);
				int value2 = nums[j] + (ids[i][j - 1] == i ? maxScore[i + 1][j - 1]
				                                          : (j - 2 >= 0 ? maxScore[i][j - 2] : 0));
				if (value1 > value2) {
					maxScore[i][j] = value1;
					ids[i][j] = i;
				}
				else {
					maxScore[i][j] = value2;
					ids[i][j] = j;
				}
			}
		}
		int value1 = maxScore[0][n - 1];
		int value2 = n - 1 > 0 ? (ids[0][n - 1] == 0 ? maxScore[1][n - 1] : maxScore[0][n - 2]) : 0;
		return value1 > value2;
	}
}
