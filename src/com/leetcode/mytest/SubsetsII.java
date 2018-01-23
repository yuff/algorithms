package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {
	public static void main(String[] args) {
		SubsetsII ss = new SubsetsII();
		System.out.println(ss.subsetsWithDup(new int[] {4, 4, 4, 1, 4}));
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		if (nums == null || nums.length == 0) {
			return new ArrayList<>(result);
		}
		int n = nums.length;
		List<Integer> tmp = new ArrayList<>();
		result.add(new ArrayList<>());
		for (int len = 1; len <= n; len++) {
			for (int i = 0; i < n - i; i++) {
				subset(result, tmp, nums, i, len);
			}
		}
		return new ArrayList<>(result);
	}

	private void subset(Set<List<Integer>> result, List<Integer> tmp, int[] nums, int start, int len) {
		if (tmp.size() == len) {
			List<Integer> t = new ArrayList<>(tmp);
			Collections.sort(t);
			result.add(t);
			return;
		}
		int n = nums.length;
		for (int i = start; i < n; i++) {
			tmp.add(nums[i]);
			subset(result, tmp, nums, i + 1, len);
			tmp.remove(tmp.size() - 1);
		}
	}
}
