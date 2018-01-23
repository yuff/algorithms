package com.leetcode.mytest;

public class WiggleSubsequence {
	public static void main(String[] args) {
		WiggleSubsequence ws = new WiggleSubsequence();
		System.out.println(ws.wiggleMaxLength(new int[] {4}));
		System.out.println(ws.wiggleMaxLength(new int[] {1, 7, 4, 9, 2, 5}));
		System.out.println(ws.wiggleMaxLength(new int[] {1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
		System.out.println(ws.wiggleMaxLength(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}));
	}

	public int wiggleMaxLength(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length, result = 1;
		int[] pos = new int[n], neg = new int[n];
		pos[0] = 1;
		neg[0] = 1;
		for (int i = 1; i < n; i++) {
			int tmp = 1, tmp2 = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					tmp = Math.max(tmp, neg[j] + 1);
				}
				else if (nums[j] > nums[i]) {
					tmp2 = Math.max(tmp2, pos[j] + 1);
				}
			}
			pos[i] = tmp;
			neg[i] = tmp2;
			result = Math.max(result, Math.max(pos[i], neg[i]));
		}
		return result;
	}
}
