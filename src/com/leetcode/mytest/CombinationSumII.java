package com.leetcode.mytest;

import java.util.*;

public class CombinationSumII {
	public static void main(String[] args) {
		CombinationSumII cs = new CombinationSumII();
		int[] nums = new int[] {10, 1, 2, 7, 6, 1, 5};
		System.out.println(cs.combinationSum2(nums, 8));
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0) {
			return new ArrayList<>();
		}
		Set<List<Integer>> result = new HashSet<>();
		List<Integer> tmp = new ArrayList<>();
		Arrays.sort(candidates);
		combination(result, tmp, candidates, 0, 0, target);
		return new ArrayList<>(result);
	}

	private void combination(Set<List<Integer>> result, List<Integer> tmp, int[] nums, int start, int sum, int target) {
		if (tmp.size() > 0) {
			if (sum == target) {
				result.add(new ArrayList<>(tmp));
				return;
			} else if (sum > target) {				
				return;
			}
		}
		int n = nums.length;
		for (int i = start; i < n; i++) {
			if (sum + nums[i] > target) {
				continue;
			}
			else {
				tmp.add(nums[i]);
				combination(result, tmp, nums, i + 1, sum + nums[i] , target);
				tmp.remove(tmp.size() - 1);
			}
		}

	}
}
