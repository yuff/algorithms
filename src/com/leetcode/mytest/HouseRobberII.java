package com.leetcode.mytest;

public class HouseRobberII {
	public static void main(String[] args) {
		HouseRobberII hb = new HouseRobberII();
		System.out.println(hb.rob(new int[]{1,2,3,4,5}));
	}

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] max1 = new int[n], max2 = new int[n];
		max1[0] = nums[0];
		max2[0] = 0;
		for (int i = 1; i < n; i++) {
			int a1 = max1[i - 1], b1 = 0;

			if (i == n - 1) {
				max1[i] = max1[i - 1];
			}
			else if (i > 1) {
				b1 = max1[i - 2] + nums[i];
			}
			max1[i] = Math.max(a1, b1);
			int a2 = max2[i - 1], b2 = 0;
			if (i == 1) {
				b2 = nums[i];
			}
			else {
				b2 = max2[i - 2] + nums[i];
			}
			max2[i] = Math.max(a2, b2);
		}
		return Math.max(max1[n - 1], max2[n - 1]);
	}
}
