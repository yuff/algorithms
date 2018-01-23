package com.leetcode.mytest;

public class IncreasingTripletSubsequence {
	public static void main(String[] args) {
		IncreasingTripletSubsequence its = new IncreasingTripletSubsequence();
		System.out.println(its.increasingTriplet(new int[] {5, 4, 3, 2, 1}));
		System.out.println(its.increasingTriplet(new int[] {1, 2, 3, 4, 5}));
	}

	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}
		int n = nums.length;
		int[] less = new int[n];
		for (int i = 0; i < n; i++) {
			less[i] = -1;
		}
		for (int i = 1; i < n; i++) {
			boolean exist = setIndex(less, i, nums);
			if (exist) {
				return true;
			}
		}
		return false;
	}

	private boolean setIndex(int[] less, int index, int[] nums) {
		int tmp = nums[index];
		for (int i = 0; i < index; i++) {
			if (nums[i] < tmp) {
				if (less[i] == -1) {
					less[i] = index;
				}
				else {
					if (nums[less[i]] < tmp) {
						return true;
					}
					else {
						less[i] = index;
					}
				}
			}
		}
		return false;
	}
}
