package com.leetcode.mytest;

public class NumberOfLongestIncreasingSubsequence {
	public static void main(String[] args) {
		NumberOfLongestIncreasingSubsequence nlis = new NumberOfLongestIncreasingSubsequence();
		System.out.println(nlis.findNumberOfLIS(new int[] {1, 3, 5, 4, 7}));
		System.out.println(nlis.findNumberOfLIS(new int[] {1, 2, 4, 3, 5, 4, 7, 2}));
	}

	public int findNumberOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] lis = new int[n];
		int[] path = new int[n];
		lis[0] = 1;
		path[0] = 1;
		int max = 1, result = 1;
		for (int i = 1; i < n; i++) {
			int tmp = 0;
			int count = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (lis[j] > tmp) {
						tmp = lis[j];
						count = path[j];
					}
					else if (lis[j] == tmp) {
						count += path[j];
					}
				}
			}
			lis[i] = tmp + 1;
			path[i] = count;
			if (lis[i] == max) {
				result += path[i];
			}
			else if (lis[i] > max) {
				max = lis[i];
				result = path[i];
			}
		}
		return result;
	}
}
