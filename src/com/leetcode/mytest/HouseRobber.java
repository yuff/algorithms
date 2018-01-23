package com.leetcode.mytest;

public class HouseRobber {
	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.rob(new int[] {2, 1, 3, 4, 6}));
	}

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length < 2) {
			return nums[0];
		}
		int n = nums.length;
		int[] r = new int[n];
		r[0] = nums[0];
		r[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; i++) {
			int r1 = r[i - 1];
			int r2 = r[i - 2] + nums[i];
			r[i] = Math.max(r1, r2);
		}
		return r[n - 1];
	}
}
