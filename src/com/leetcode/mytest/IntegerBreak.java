package com.leetcode.mytest;

public class IntegerBreak {
	public static void main(String[] args) {
		IntegerBreak ib = new IntegerBreak();
		System.out.println(ib.integerBreak(10));
	}
	public int integerBreak(int n) {
		if (n == 0 || n == 1) {
			return 0;
		}
		else if (n == 2) {
			return 1;
		}
		int[] res = new int[n + 1];
		res[1] = 0;
		// res[2] = 1;
		for (int i = 2; i <= n; i++) {
			int r = 0;
			int size = i >> 1;
			for (int j = 1; j <= size; j++) {
				int tmp = Math.max(j, res[j]) * Math.max(i - j, res[i - j]);
				if (tmp > r) {
					r = tmp;
				}
			}
			res[i] = r;
		}
		return res[n];
	}
}
