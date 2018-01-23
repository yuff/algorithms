package com.leetcode.mytest;

public class SortColors {
	public static void main(String[] args) {
		SortColors sc = new SortColors();
		int[] nums = new int[] {2, 0, 1, 1, 2, 0, 2, 1, 0, 0, 1};
		sc.sortColors(nums);
		for (int i : nums) {
			System.out.print(i + ",");
		}
	}

	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int n = nums.length, r = 0, w = 0, b = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				r++;
			}
			else if (nums[i] == 1) {
				w++;
			}
			else {
				b++;
			}
		}

		for (int s = 0; s < r; s++) {
			nums[s] = 0;
		}
		for (int s = 0; s < w; s++) {
			nums[r + s] = 1;
		}
		for (int s = 0; s < b; s++) {
			nums[r + w + s] = 2;
		}

	}
}
