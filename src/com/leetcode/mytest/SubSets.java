package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
	public static void main(String[] args) {
		SubSets ss = new SubSets();
		List<List<Integer>> result = ss.subsets(new int[] {1, 2, 3, 4, 5});
		System.out.println(result.size());
		System.out.println(result);
	}

	public List<List<Integer>> subsets(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		int n = nums.length;
		for (int i = 1; i <= n; i++) {
			subset(nums, result, tmp, i, 0);
		}
		result.add(new ArrayList<Integer>());
		return result;
	}

	private void subset(int[] nums, List<List<Integer>> result, List<Integer> tmp, int length, int startIndex) {
		if (tmp.size() == length) {
			result.add(new ArrayList<>(tmp));
			return;
		}
		int n = nums.length;
		for (int i = startIndex; i < n; i++) {
			if (n - i < length - tmp.size()) {
				break;
			}
			else {
				tmp.add(nums[i]);
				subset(nums, result, tmp, length, i + 1);
				tmp.remove(tmp.size() - 1);
			}
		}

	}
}
