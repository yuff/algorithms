package com.leetcode.mytest;

public class SubarraySumEqualsK {
	public static void main(String[] args) {
		SubarraySumEqualsK ssek = new SubarraySumEqualsK();
		int[] nums = new int[] {1, 2, 3};
		System.out.println(ssek.subarraySum(nums, 3));
	}

	public int subarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int tmp = nums[i];
			if (tmp == k) {
				result++;
			}
			for (int j = i + 1; j < n; j++) {
				tmp += nums[j];
				if (tmp == k) {
					result++;
				}
			}
		}
		return result;
	}
}
