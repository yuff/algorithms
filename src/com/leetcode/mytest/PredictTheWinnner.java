package com.leetcode.mytest;

public class PredictTheWinnner {
	public static void main(String[] args) {
		PredictTheWinnner ptw = new PredictTheWinnner();
		int[] nums = new int[] {1, 5, 2};
		System.out.println(ptw.predictTheWinner(nums));
	}

	public boolean predictTheWinner(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int n = nums.length;
		int[][] scores = new int[n][n];
		int[][] index = new int[n][n];
		for (int i = 0; i < n; i++) {
			scores[i][i] = nums[i];
			index[i][i] = i;
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				int a = nums[i];
				int id = index[i + 1][j];
				if ((i + 1) < j) {
					if (id == i + 1) {
						a += scores[i + 2][j];
					}
					else {
						a += scores[i + 1][j - 1];
					}
				}

				int b = nums[j];
				id = index[i][j - 1];
				if (i < (j - 1)) {
					if (id == i) {
						b += scores[i + 1][j - 1];
					}
					else {
						b += scores[i][j - 2];
					}
				}
				if (a < b) {
					scores[i][j] = b;
					index[i][j] = j;
				}
				else {
					scores[i][j] = a;
					index[i][j] = i;
				}
			}
		}
		int p1 = scores[0][n - 1];
		int i = index[0][n - 1];
		int p2 = 0;
		if (n > 1) {
			if (i == 0) {
				p2 = scores[1][n - 1];
			}
			else {
				p2 = scores[0][n - 2];
			}
		}

		return p1 >= p2;
	}
}
