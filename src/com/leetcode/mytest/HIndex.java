package com.leetcode.mytest;

import java.util.Arrays;

public class HIndex {
	public static void main(String[] args) {
		HIndex hi = new HIndex();
		System.out.println(hi.hIndex(new int[]{3, 0, 6, 1, 5}));
	}
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		Arrays.sort(citations);
		int n = citations.length;
		int[] c = new int[n];
		if (citations[0] < n) {
			c[0] = -1;
		}
		else {
			return n;
		}
		int result = 0;
		for (int i = 1; i < n; i++) {
			int t = citations[i] < n - i ? -1 : n - i;
			c[i] = Math.max(c[i - 1], t);
			if (c[i] > result) {
				result = c[i];
			}
		}
		return result;
	}
}
