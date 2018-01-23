package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public static void main(String[] args) {
		Combinations cb = new Combinations();
		System.out.println(cb.combine(6, 3).size());
		System.out.println(cb.combine(6, 3));
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if (n < k) {
			return result;
		}
		List<Integer> tmp = new ArrayList<>();
		combine(result, tmp, 1, n, k);
		return result;
	}

	private void combine(List<List<Integer>> result, List<Integer> tmp, int startIndex, int n, int k) {
		if (tmp.size() == k) {
			result.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = startIndex; i <= n; i++) {
			tmp.add(i);
			combine(result, tmp, i + 1, n, k);
			tmp.remove(tmp.size() - 1);
		}

	}
}
