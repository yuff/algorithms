package com.leetcode.newround;

public class IntegerBreak {
	public static void main(String[] args) {
		IntegerBreak ib = new IntegerBreak();
		System.out.println(ib.integerBreak(10));
		System.out.println(ib.integerBreak(2));
	}
	public int integerBreak(int n) {
		if (n < 1) {
			return n;
		}
		int[] max = new int[n + 1];
		max[1] = 1;
		for (int i = 2; i <= n; i++) {
			int curMax = 0;
			for (int j = 1; j < i; j++) {
				int cur =  Math.max(j, max[j]) * Math.max(i - j, max[i - j]);
				curMax = Math.max(curMax, cur);
			}
			max[i] = curMax;
		}
		return max[n];
	}
}
