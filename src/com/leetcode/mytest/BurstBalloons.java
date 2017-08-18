package com.leetcode.mytest;

import java.util.List;

public class BurstBalloons {

	public static void main(String[] args) {
		BurstBalloons bb = new BurstBalloons();
		int[] nums = new int[] {3, 1, 5, 8};
		System.out.println(bb.maxCoins(nums));
	}

	public int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[][] max = new int[n][n];

		for (int len = 1; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				int j = i + len - 1;
				int m = 0;
				for (int k = i; k <= j; k++) {
					int tmp = nums[k] * (i > 0 ? nums[i - 1] : 1) * (j < (n - 1) ? nums[j + 1] : 1);
					if (k != j) {
						tmp += max[k + 1][j];
					}
					if (k != i) {
						tmp += max[i][k - 1];
					}
					if (tmp > m) {
						m = tmp;
					}
				}
				max[i][j] = m;
			}
		}

		return max[0][n - 1];
	}

	private void findMax(int[] nums, List<Integer> seq, int[] result, int curValue) {
		int n = nums.length;
		if (seq.size() == n) {
			if (curValue > result[0]) {
				result[0] = curValue;
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!seq.contains(i)) {
				int add = addCoins(seq, nums, i);
				seq.add(i);
				findMax(nums, seq, result, curValue + add);
				seq.remove(seq.size() - 1);
			}
		}
	}

	private int addCoins(List<Integer> seq, int[] nums, int i) {
		int preValue = 1, nextValue = 1;
		int pre = i - 1;
		int next = i + 1;
		while (seq.contains(pre)) {
			pre--;
		} ;
		if (pre >= 0) {
			preValue = nums[pre];
		}
		while (seq.contains(next)) {
			next++;
		}
		if (next < nums.length) {
			nextValue = nums[next];
		}
		return preValue * nums[i] * nextValue;
	}
}
