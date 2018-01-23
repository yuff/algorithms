package com.leetcode.mytest;

public class MaximumSubarray {
	public static void main(String[] args) {
		MaximumSubarray ms = new MaximumSubarray();
		System.out.println(ms.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}

	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] sums = new int[n];
		sums[n - 1] = nums[n - 1];
		int max = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (sums[i + 1] > 0) {
				sums[i] = nums[i] + sums[i + 1];
			}
			else {
				sums[i] = nums[i];
			}
			if (sums[i] > max) {
				max = sums[i];
			}
		}
		return max;
	}
}
