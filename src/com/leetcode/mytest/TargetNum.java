package com.leetcode.mytest;

import java.util.Arrays;

public class TargetNum {
	public static void main(String[] args) {
		TargetNum tn = new TargetNum();
		int[] nums = new int[] {1, 2, 3, 4, 5, 0, 0 ,0};
//		System.out.println(tn.findTargetSumWays(nums, 9));
		System.out.println(tn.findTargetSumWaysDP(nums, 9));
	}
	public int findTargetSumWaysDP(int[] nums, int S) {
		int[] r = new int[1];
		count(nums, 0, 0, r,S);
		return r[0];
	}
	private void count(int[] nums, int index, int result, int[] r, int target) {
		int n = nums.length;
		if (index == n ) {
			if (result == target) {
				r[0]  = r[0] + 1;
			}
			return;
		}
		int value = nums[index];
		count(nums, index + 1, result + value, r, target);
		count(nums, index + 1, result - value, r, target);
	}
	public int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		int zeroCount = 0;
		for (int num : nums) {
			sum += num;
			if (num == 0) {
				zeroCount++;
			}
		}
		if (sum < S) {
			return 0;
		}
		else if (sum == S) {
			return 1 << zeroCount;
		}
		else {
			int dis = sum - S;
			if (dis % 2 != 0) {
				return 0;
			}
			else {
				dis = dis >> 1;
			}
			Arrays.sort(nums);
			int count = 0;
			for (int num : nums) {
				if (num > dis) {
					break;
				}
				if (num != 0) {
					count++;
				}

			}
			int[][] res = new int[dis + 1][count];
			for (int i = 0; i <= dis; i++) {
				if (nums[zeroCount] == i) {					
					res[i][0] = 1;
				} else {
					res[i][0] = 0;
				}
			}

			for (int i = 0; i < count; i++) {
				res[0][i] = 1;
			}
			for (int i = 1; i <= dis; i++) {
				for (int j = 1; j < count; j++) {
					int value = nums[zeroCount + j];
					int a = 0, b = 0;
					if (value <= i) {
						a = res[i - value][j - 1];
					}
					b = res[i][j - 1];
					res[i][j] = a + b;
				}
			}
			return res[dis][count - 1] * (1 << zeroCount);
		}
	}
}
