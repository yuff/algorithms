package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	public static void main(String[] args) {
		CombinationSumIII cs = new CombinationSumIII();
		System.out.println(cs.combinationSum3(2, 18));
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		build(n, result, tmp, k);
		return result;
	}

	private void build(int n, List<List<Integer>> result, List<Integer> tmp, int k) {
		if (k == 0) {
			if (sum(tmp) == n) {
				List<Integer> r = new ArrayList<>();
				r.addAll(tmp);
				result.add(r);
			}
			return;
		}
		int size = tmp.size();
		int b = 1;
		if (size > 0) {
			b = tmp.get(size - 1) + 1;
		}
		for (int i = b; i <= 9; i++) {
			tmp.add(i);
			size = tmp.size();
			if (sum(tmp) > n || (k > 1 && ((sum(tmp) + i + 1)) > n)) {
				tmp.remove(size - 1);
			}
			else {
				build(n, result, tmp, k - 1);
				tmp.remove(tmp.size() - 1);
			}
		}
	}

	private int sum(List<Integer> tmp) {
		int result = 0;
		for (int i : tmp) {
			result += i;
		}
		return result;
	}
}
