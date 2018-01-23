package com.leetcode.mytest;

public class SetMismatch {
	public static void main(String[] args) {
		SetMismatch sm = new SetMismatch();
		int[] result = sm.findErrorNums(new int[] {1, 2, 2, 4});
		for (int i : result) {
			System.out.print(i + ",");
		}
	}

	public int[] findErrorNums(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int n = nums.length;
		int[] count = new int[n + 1];
		int[] result = new int[2];
		for (int num : nums) {
			count[num] += 1;
		}
		for (int i = 1; i <= n; i++) {
			if (count[i] == 0) {
				result[1] = i;
			}
			else if (count[i] == 2) {
				result[0] = i;
			}
		}
		return result;
	}
}
