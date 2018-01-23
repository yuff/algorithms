package com.leetcode.newround;

public class JumpGame {
	public static void main(String[] args) {
		JumpGame jg = new JumpGame();
		int[] nums = new int[]{2,3,1,1,4};
		System.out.println(jg.canJump(nums ));
	}
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return true;
		}
		int n = nums.length, i = 0, step = nums[0];
		boolean[] canVisit = new boolean[n];
		canVisit[0] = true;
		while (i < n) {
			step = nums[i];
			if (step == 0) {
				break;
			}
			if (canVisit[i]) {
				for (int j = i + 1; j <= Math.min(n - 1, i + step); j++) {
					step = Math.max(j + nums[j], step);
					canVisit[j] = true;
				}
			}
			i = (i + step + 1);
		}
		return canVisit[n - 1];
	}
}
