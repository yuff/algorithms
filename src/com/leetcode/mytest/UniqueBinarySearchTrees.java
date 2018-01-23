package com.leetcode.mytest;

public class UniqueBinarySearchTrees {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		UniqueBinarySearchTrees ub = new UniqueBinarySearchTrees();
		System.out.println(ub.numTrees(19));
	}

	public int numTrees(int n) {
		if (n == 0) {
			return 0;
		}
		int[] r = new int[n + 1];
		r[0] = 1;
		r[1] = 1;
		for (int i = 2; i <= n; i++) {
			int num = i >> 1;
			for (int j = 1; j <= num; j++) {
				r[i] += (2 * r[j - 1] * r[i - j]);
			}
			if ((i - 1) % 2 == 0) {
				r[i] += r[(i - 1) / 2] * r[(i - 1) / 2];
			}
		}
		return r[n];
	}
}
