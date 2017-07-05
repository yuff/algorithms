package com.leetcode.mytest;

public class FirstMissingPositive {
	public static void main(String[] args) {
		int[] arr = {3, 2, -1, 5};
		System.out.println(new FirstMissingPositive().firstMissingPositive(arr));
	}

	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] > 0 && nums[i] != i + 1) {
				process(nums, i);
			}
		}
		for (int i = 0; i < len; i++) {
			if (nums[i] <= 0) {
				return i + 1;
			}
		}
		return len + 1;
	}

	private void process(int[] nums, int index) {
		int len = nums.length;
		int value = nums[index];
		nums[index] = -1;
		while (value > 0 && value <= len) {
			int tmp = nums[value - 1];
			nums[value - 1] = value;
			if (value == tmp) {
				value = -1;
			}
			else {
				value = tmp;
			}
		}
	}
}
