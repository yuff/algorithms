package com.leetcode.mytest;

public class MaximumAverageSubarray {
	public static void main(String[] args) {
		MaximumAverageSubarray ma = new MaximumAverageSubarray();
		System.out.println(ma.findMaxAverage(new int[] {-1}, 1));
	}

	public double findMaxAverage(int[] nums, int k) {
		if (nums == null || nums.length < k || k <= 0) {
			return 0;
		}
		int n = nums.length;
		int count = 0;
		double sum = 0, max = (double)Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (count < k) {
				sum += nums[i];
				count++;
			}
			else {
				if (sum > max) {
					max = sum;
				}
				sum += (nums[i] - nums[i - k]);
			}
		}
		if (sum > max) {
			max = sum;
		}
		return max / k;
	}
}
