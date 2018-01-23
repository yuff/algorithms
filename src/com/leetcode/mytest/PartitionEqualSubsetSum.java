package com.leetcode.mytest;

public class PartitionEqualSubsetSum {
	public static void main(String[] args) {
		PartitionEqualSubsetSum pess = new PartitionEqualSubsetSum();
		System.out.println(pess.canPartition(new int[] {1, 2, 3, 5, 1}));
	}

	public boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int n = nums.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0) {
			return false;
		}
		int target = sum >> 1;
		boolean[][] exist = new boolean[n][target + 1];
		for (int i = 0; i < n; i++) {
			if (nums[i] == target) {
				return true;
			}
			exist[i][0] = false;
		}
		if (nums[0] <= target) {
			exist[0][nums[0]] = true;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= target; j++) {
				boolean b1 = false, b2 = false;
				if (j >= nums[i]) {
					b1 = exist[i - 1][j - nums[i]];
				}
				b2 = exist[i - 1][j];
				exist[i][j] = b1 || b2;
			}
		}
		return exist[n - 1][target];
	}
}
