package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumIV {
	public static void main(String[] args) {
		CombinationSumIV cs = new CombinationSumIV();
		int[] nums = new int[] {1, 50};
		System.out.println(cs.combinationSum(nums, 200));
		System.out.println(cs.combinationSum4(nums, 200));
	}

	public int combinationSum(int[] nums, int target) {
		boolean[] exist = new boolean[target + 1];
		int[] coms = new int[target + 1];
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] <= target) {
				exist[nums[i]] = true;
			}
		}
		coms[0] = 1;
		for (int i = 1; i <= target; i++) {
			int sum = 0;
			for (int j = 1; j <= i; j++) {
				if (exist[j]) {
					sum += coms[i - j];
				}
			}
			coms[i] = sum;
		}
		return coms[target];
	}

	public int combinationSum4(int[] nums, int target) {
		if (nums == null || nums.length == 0 || target <= 0) {
			return 0;
		}
		boolean[] exist = new boolean[target + 1];
		int[] coms = new int[target + 1];
		List<Set<List<Integer>>> list = new ArrayList<>(target + 1);
		list.add(null);
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] <= target) {
				exist[nums[i]] = true;
			}
		}
		coms[0] = 1;
		for (int i = 1; i <= target; i++) {
			Set<List<Integer>> set = new HashSet<>();
			if (exist[i]) {
				List<Integer> own = new ArrayList<>();
				own.add(i);
				set.add(own);
			}
			for (int j = 1; j <= i >> 1; j++) {
				Set<List<Integer>> jList = list.get(j);
				Set<List<Integer>> reList = list.get(i - j);
				for (List<Integer> je : jList) {
					for (List<Integer> re : reList) {
						List<Integer> tmp = new ArrayList<>();
						tmp.addAll(je);
						tmp.addAll(re);
						set.add(new ArrayList<>(tmp));
						tmp.clear();
						tmp.addAll(re);
						tmp.addAll(je);
						set.add(new ArrayList<>(tmp));
					}
				}
			}
			list.add(set);
		}
		return list.get(target).size();
	}
}
