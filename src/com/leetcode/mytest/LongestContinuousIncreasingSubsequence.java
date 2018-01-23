package com.leetcode.mytest;

public class LongestContinuousIncreasingSubsequence {
	public static void main(String[] args) {
		LongestContinuousIncreasingSubsequence lc = new LongestContinuousIncreasingSubsequence();
		System.out.println(lc.findLengthOfLCIS(new int[] {1, 3, 5, 4, 7}));
		System.out.println(lc.findLengthOfLCIS(new int[] {2, 2, 2, 2}));
	}

	public int findLengthOfLCIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] len = new int[n];
		len[0] = 1;
		int result = 1;
		for (int i = 1; i < n; i++) {
			if (nums[i] > nums[i - 1]) {
				len[i] = len[i - 1] + 1;
				if (len[i] > result) {
					result = len[i];
				}
			}
			else {
				len[i] = 1;
			}
		}
		return result;
	}
}
