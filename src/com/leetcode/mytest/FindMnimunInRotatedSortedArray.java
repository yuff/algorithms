package com.leetcode.mytest;

public class FindMnimunInRotatedSortedArray {
	public static void main(String[] args) {
		FindMnimunInRotatedSortedArray fm = new FindMnimunInRotatedSortedArray();
		System.out.println(fm.findMin(new int[] {4,4 ,4,5,5, 6, 7, -1, 0, 1, 2, 2}));
	}

	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			throw new RuntimeException("error input");
		}
		int len = nums.length;
		int min = nums[0], pre = nums[0];
		for (int i = 1; i < len; i++) {
			if (nums[i] < pre) {
				min = nums[i];
				break;
			}
			else {
				pre = nums[i];
			}
		}
		return min;
	}
}
