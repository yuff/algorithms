package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CombinationSum {
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		System.out.println(cs.combinationSum(new int[] {2, 3, 6, 7, 1, 1}, 7));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (target <= 0 || candidates == null || candidates.length == 0) {
			return new ArrayList<List<Integer>>();
		}
		Map<Integer, Set<List<Integer>>> map = new HashMap<>();
		int n = candidates.length;
		for (int i = 1; i <= target; i++) {
			map.put(i, new HashSet<List<Integer>>());
			for (int j = 0; j < n; j++) {
				if (candidates[j] > i) {
					continue;
				}
				else if (candidates[j] == i) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(candidates[j]);
					map.get(i).add(tmp);
				}
				else {
					int minus = i - candidates[j];
					Set<List<Integer>> set = map.get(minus);
					for (List<Integer> list : set) {
						List<Integer> r = new ArrayList<>(list);
						r.add(candidates[j]);
						Collections.sort(r);
						map.get(i).add(r);
					}
				}
			}
		}
		return new ArrayList<>(map.get(target));
	}
}
