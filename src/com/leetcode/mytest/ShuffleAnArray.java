package com.leetcode.mytest;

import java.util.Random;

public class ShuffleAnArray {
	private int[] nums;

	public ShuffleAnArray(int[] nums) {
		this.nums = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int length = nums.length;
		int[] result = new int[length];
		int[] flag = new int[length];
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt() % length;
			while (index < 0 || index == i || flag[index] != 0) {
				index = random.nextInt() % length;
			}
			flag[index] = 1;
			result[i] = nums[index];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		ShuffleAnArray sa = new ShuffleAnArray(arr );
		System.out.println(sa.shuffle());
	}
}
