package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductSubarray {
	public static void main(String[] args) {
		MaximumProductSubarray mp = new MaximumProductSubarray();
		System.out.println(mp.maxProduct(new int[] {-5,0,-2}));
	}

	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}
		int[] multi = new int[n];
		multi[0] = nums[0];
		List<Integer> zeros = new ArrayList<>();
		List<List<Integer>> minus = new ArrayList<>();
		List<Integer> m = new ArrayList<>();
		if (nums[0] < 0) {
			m.add(0);
		}
		for (int i = 1; i < n; i++) {
			if (nums[i] == 0) {
				zeros.add(i);
				minus.add(new ArrayList<>(m));
				m.clear();
			}
			else if (nums[i] < 0) {
				m.add(i);
			}
			multi[i] = (multi[i - 1] == 0 ? 1 : multi[i - 1]) * nums[i];
		}
		zeros.add(n);
		minus.add(m);
		int prod = Integer.MIN_VALUE;
		for (int i = 0; i < zeros.size(); i++) {
			int zero = zeros.get(i);
			if (multi[zero - 1] >= 0) {
				prod = Math.max(prod, multi[zero - 1]);
			}
			else if (multi[zero - 1] < 0) {
				int tmp = multi[zero - 1];
				List<Integer> mi = minus.get(i);
				for (int t : mi) {
					int left = t > 0 ? multi[t - 1] : Integer.MIN_VALUE;
					int right = zero - 1 == t?Integer.MIN_VALUE:  tmp / multi[t];
					prod = Math.max(Math.max(left, right), prod);
				}
			}
		}
		return prod;
	}
}
