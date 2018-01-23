package com.leetcode.mytest;

import java.util.*;

public class PermutationsII {
	public static void main(String[] args) {
		PermutationsII p = new PermutationsII();
		int[] nums = new int[] {3, 3, 1, 2, 3, 2, 3, 1};
		System.out.println(p.permuteUnique(nums));
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		Set<List<Integer>> result = new HashSet<>();
		List<Integer> tmp = new ArrayList<>();
		int n = nums.length;
		boolean[] used = new boolean[n];
		permute(result, tmp, nums, used);
		return new ArrayList<>(result);
	}

	private void permute(Set<List<Integer>> result, List<Integer> tmp, int[] nums, boolean[] used) {
		if (tmp.size() == nums.length) {
			result.add(new ArrayList<>(tmp));
			return;
		}
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				tmp.add(nums[i]);
				used[i] = true;
				permute(result, tmp, nums, used);
				tmp.remove(tmp.size() - 1);
				used[i] = false;
			}
		}
	}
}
