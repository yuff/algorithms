package com.leetcode.mytest;

public class BurstBalloons_2 {

	public static void main(String[] args) {
		BurstBalloons_2 bb = new BurstBalloons_2();
		int[] nums = new int[] {7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3};
		System.out.println(bb.maxCoins(nums));
	}

	public int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] result = new int[1];
		boolean[] seq = new boolean[n];
		findMax(nums, seq, result, 0, 0);
		return result[0];
	}

	private void findMax(int[] nums, boolean[] seq, int[] result, int curValue, int count) {
		int n = nums.length;
		if (count == n) {
			if (curValue > result[0]) {
				result[0] = curValue;
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!seq[i]) {
				int add = addCoins(seq, nums, i);
				seq[i] = true;
				findMax(nums, seq, result, curValue + add, count + 1);
				seq[i] = false;
			}
		}
	}

	private int addCoins(boolean[] seq, int[] nums, int i) {
		int n = nums.length;
		int preValue = 1, nextValue = 1;
		int pre = i - 1;
		int next = i + 1;
		while (pre >= 0 && seq[pre]) {
			pre--;
		} ;
		if (pre >= 0) {
			preValue = nums[pre];
		}
		while (next < n && seq[next]) {
			next++;
		}
		if (next < n) {
			nextValue = nums[next];
		}
		return preValue * nums[i] * nextValue;
	}
}
