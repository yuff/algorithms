package com.leetcode.mytest;

public class MatchsticksToSquare {
	public static void main(String[] args) {
		MatchsticksToSquare mts = new MatchsticksToSquare();
		System.out.println(mts.makesquare(new int[] {1, 1, 2, 3, 4, 4, 5}));
		System.out.println(mts.makesquare(new int[] {1, 1, 2, 3, 4, 4, 5, 6}));
	}

	public boolean makesquare(int[] nums) {
		if (nums == null || nums.length < 4) {
			return false;
		}
		int sum = 0, n = nums.length;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
		}
		if (sum % 4 != 0) {
			return false;
		}
		else {
			int ave = sum >> 2;
			return makesquare(nums, new int[4], 0, ave);
		}
	}

	private boolean makesquare(int[] nums, int[] sum, int id, int ave) {
		if (id == nums.length) {
			if (sum[0] == sum[1] && sum[1] == sum[2] && sum[2] == sum[3]) {
				return true;
			}
			else {
				return false;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (sum[i] + nums[id] <= ave) {
				sum[i] += nums[id];
				if (makesquare(nums, sum, id + 1, ave)) {
					return true;
				}
				else {
					sum[i] -= nums[id];
				}
			}
			else {
				continue;
			}
		}
		return false;
	}
}
