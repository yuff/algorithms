package com.leetcode.mytest;

public class MissingNumber268 {
	public static void main(String[] args) {
		MissingNumber268 mn = new MissingNumber268();
		int[] nums = new int[] {1, 3, 0};
		System.out.println(mn.missingNumber(nums));
	}

	public int missingNumber(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		boolean[] b = new boolean[n + 1];
		for (int i : nums) {
			b[i] = true;
		}
		int missing = 0;
		for (int i = 0; i <= n; i++) {
			if (!b[i]) {
				missing = i;
				break;
			}
		}
		return missing;
	}
}
