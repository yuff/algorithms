package com.leetcode.mytest;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {

	public static void main(String[] args) {
		int[][] pairs = new int[5][2];
		pairs[0] = new int[]{1,2};
		pairs[1] = new int[]{2,3};
		pairs[2] = new int[]{3,4};
		pairs[3] = new int[]{4,9};
		pairs[4] = new int[]{5,8};
		MaximumLengthOfPairChain mlpc = new MaximumLengthOfPairChain();
		System.out.println(mlpc.findLongestChain(pairs));
	}
	public int findLongestChain(int[][] pairs) {
		if (pairs == null) {
			return 0;
		}
		int n = pairs.length;
		Arrays.sort(pairs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		int[] chain = new int[n];
		chain[0] = 1;
		int result = chain[0];
		for (int i = 1; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (pairs[j][0] > pairs[i][1] && chain[j] > max) {
					max = chain[j];
				}
			}
			chain[i] = max + 1;
			if (chain[i] > result) {
				result = chain[i];
			}
		}
		return result;
	}
}
