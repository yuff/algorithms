package com.leetcode.newround;

public class ReversePairs {
	public static void main(String[] args) {
		ReversePairs rp = new ReversePairs();
		System.out.println(rp.reversePairs(new int[] {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
	}

	public int reversePairs(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int n = nums.length, result = 0;
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if ((long)nums[i] >2l * nums[j]) {
					result++;
				}
			}
        }
		return result;      
	}
}
