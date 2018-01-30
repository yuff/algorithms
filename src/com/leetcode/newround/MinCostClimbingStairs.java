package com.leetcode.newround;

public class MinCostClimbingStairs {
	public static void main(String[] args) {
		MinCostClimbingStairs mc = new MinCostClimbingStairs();
		System.out.println(mc.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
		System.out.println(mc.minCostClimbingStairs(new int[] {10, 15, 20}));
	}

	public int minCostClimbingStairs(int[] cost) {
		if (cost == null || cost.length < 2) {
			return 0;
		}
		int n = cost.length;
		int[] total = new int[n + 1];
		total[0] = 0;
		total[1] = 0;
		for (int i = 2; i <= n; i++) {
			total[i] = Math.min(total[i - 1] + cost[i - 1], total[i - 2] + cost[i - 2]);
		}
		return total[n];
	}
}
