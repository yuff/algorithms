package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsquences {
	public static void main(String[] args) {
		IncreasingSubsquences is = new IncreasingSubsquences();
		List<List<Integer>> result =
		                is.findSubsequences(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
		System.out.println(result.size());
//		System.out.println(result);
	}

	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		List<Integer> tmp = new ArrayList<>();
		findSubsequences(nums, result, tmp, 0);
		return result;
	}

	private void findSubsequences(int[] nums, List<List<Integer>> result, List<Integer> tmp, int start) {
		if (result.contains(tmp)) {
			return;
		}
		else {
			if (tmp.size() > 1) {
				result.add(new ArrayList<Integer>(tmp));
			}
		}

		int n = nums.length;
		int pre = tmp.size() == 0 ? Integer.MIN_VALUE : tmp.get(tmp.size() - 1);
		for (int i = start; i < n; i++) {
			if (nums[i] < pre) {
				continue;
			}
			else {
				tmp.add(nums[i]);
				findSubsequences(nums, result, tmp, i + 1);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
