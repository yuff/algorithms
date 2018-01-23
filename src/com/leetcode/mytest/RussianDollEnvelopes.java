package com.leetcode.mytest;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
	public static void main(String[] args) {
		RussianDollEnvelopes re = new RussianDollEnvelopes();
		int[][] envelopes = new int[4][2];
		envelopes[0] = new int[] {5, 4};
		envelopes[1] = new int[] {6, 4};
		envelopes[2] = new int[] {6, 7};
		envelopes[3] = new int[] {2, 3};
		System.out.println(re.maxEnvelopes(envelopes));
	}

	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}
		int n = envelopes.length;
		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				else {
					return o1[0] - o2[0];
				}
			}
		});
		int[] max = new int[n];
		max[0] = 1;
		int res = 1;
		for (int i = 1; i < n; i++) {
			int tmp = 0;
			for (int j = 0; j < i; j++) {
				if (canFit(envelopes[i], envelopes[j]) && tmp < max[j]) {
					tmp = max[j];
				}
			}
			max[i] = tmp + 1;
			if (max[i] > res) {
				res = max[i];
			}
		}
		return res;
	}

	private boolean canFit(int[] a, int[] b) {
		return a[0] > b[0] && a[1] > b[1];
	}
}
