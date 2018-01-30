package com.leetcode.newround;

import java.util.*;

public class ArithmeticSlices {
	public static void main(String[] args) {
		ArithmeticSlices as = new ArithmeticSlices();
		System.out.println(as.numberOfArithmeticSlices(new int[] {1, 2, 3, 4, 5, 7, 9, 11}));
		// System.out.println(as.numberOfArithmeticSlices(new int[]{1, 3, 5, 7, 9}));
		// System.out.println(as.numberOfArithmeticSlices(new int[]{1, 1, 2, 5, 7}));
	}

	public int numberOfArithmeticSlices(int[] A) {
		if (A == null || A.length < 3) {
			return 0;
		}
		int n = A.length;
		List<Integer> lens = new ArrayList<>();
		int start = 0;
		while (start <= n - 3) {
			int one = A[start], two = A[start + 1], dis = two - one, count = 2, i = start + 2;
			while (i < n) {
				if (A[i] - two == dis) {
					two = A[i];
					count++;
					i++;
				}
				else {
					break;
				}
			}
			lens.add(count);
			start = i - 1;
		}
		int result = 0;
		for (int len : lens) {
			result += ((len - 2) * (len - 1) / 2);
		}
		return result;
	}
}
