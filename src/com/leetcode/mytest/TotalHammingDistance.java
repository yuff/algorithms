package com.leetcode.mytest;

public class TotalHammingDistance {

	public static void main(String[] args) {
		TotalHammingDistance thd = new TotalHammingDistance();
		System.out.println(thd.totalHammingDistance(new int[] {4, 14, 2}));
	}

	public int totalHammingDistance(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int result = 0;
		for (int i = 1; i <= 32; i++) {
			int bitCounts = 0;
			for (int j = 0; j < n; j++) {
				bitCounts += (nums[j] >> i) & 1;
			}
			result += bitCounts * (n - bitCounts);
		}
		return result;
	}
}
