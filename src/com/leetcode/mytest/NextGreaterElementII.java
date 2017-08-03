package com.leetcode.mytest;

public class NextGreaterElementII {
	public static void main(String[] args) {
		NextGreaterElementII nge = new NextGreaterElementII();
		int[] nums = new int[] {1, 2, 3, 2, 1};
		int[] result = nge.nextGreaterElement(nums);
		for (int i : result) {
			System.out.print(i);
			System.out.print(",");
		}
	}

	public int[] nextGreaterElement(int[] nums) {
		return nums;
		// TODO
	}
}
