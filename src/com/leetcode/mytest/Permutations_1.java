package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class Permutations_1 {
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3};
		List<List<Integer>> result = new Permutations_1().permute(nums);
		System.out.println(result.size());
	}

	public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<List<Integer>>();
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> numList = new ArrayList<>();
		premute(nums, result, numList, 0, new boolean[nums.length]);
		return result;
	}

	public void premute(int[] nums, List<List<Integer>> result, List<Integer> tmp, int depth, boolean[] isVisited) {
		if (depth == nums.length) {
			result.add(new ArrayList<>(tmp));
			return;
		}
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (!isVisited[i]) {
				tmp.add(nums[i]);
				isVisited[i] = true;
				premute(nums, result, tmp, depth + 1, isVisited);
				isVisited[i] = false;
				tmp.remove(tmp.size() - 1);
			}
		}
	}
	// public List<List<Integer>> permute(int[] nums) {
	// List<List<Integer>> res = new ArrayList<List<Integer>>();
	//
	// helper(nums, res, new ArrayList<Integer>(), 0, new boolean[nums.length]);
	// return res;
	// }
	//
	// void helper(int[] nums, List<List<Integer>> res, List<Integer> tmp, int depth, boolean[]
	// visited) {
	// if (depth == nums.length) {
	// res.add(new ArrayList<Integer>(tmp));
	// }
	//
	// for (int i = 0; i < nums.length; i++) {
	// if (!visited[i]) {
	// tmp.add(nums[i]);
	// visited[i] = true;
	// helper(nums, res, tmp, depth + 1, visited);
	// visited[i] = false;
	// tmp.remove(tmp.size() - 1);
	// }
	// }
	// }
}
