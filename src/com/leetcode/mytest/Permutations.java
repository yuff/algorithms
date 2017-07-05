package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3};
		List<List<Integer>> result = new Permutations().permute(nums);
		System.out.println(result.size());
	}

	public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<List<Integer>>();
		}
		List<Integer> numList = new ArrayList<>();
		for (int num : nums) {
			numList.add(num);
		}
		return premute(numList);
	}

	public List<List<Integer>> premute(List<Integer> list) {
		List<List<Integer>> result = new ArrayList<>();
		if (list.size() == 1) {
			result.add(list);
			return result;
		}
		int size = list.size();
		for (int i = 0; i < size; i++) {
			List<Integer> li = new ArrayList<>(list);
			int removeEle = li.remove(i);
			List<List<Integer>> iPreResult = premute(li);
			for (List<Integer> r : iPreResult) {
				r.add(removeEle);
				result.add(r);
			}
		}
		return result;
	}
	// public List<List<Integer>> permute(int[] nums) {
	// List<List<Integer>> result = new ArrayList<>();
	// int length = nums.length;
	// if (length == 0) {
	// return result;
	// }
	// List<Integer> list = new ArrayList<>();
	// for(int num: nums) {
	// list.add(num);
	// }
	// result.add(list);
	// int count = 0;
	// while(count < length) {
	// List<List<Integer>> tmp = new ArrayList<>();
	// for(int i = count + 1; i < length; i++) {
	// for (List<Integer> l : result) {
	// List<Integer> nList = new ArrayList<>(l);
	// tmp.add(swap(nList, count, i));
	// }
	//
	// }
	// result.addAll(tmp);
	// count++;
	// }
	// return result;
	// }
	// private List<Integer> swap(List<Integer> list, int i, int j) {
	// int iValue = list.get(i);
	// int jValue = list.get(j);
	// list.set(i, jValue);
	// list.set(j, iValue);
	// return list;
	// }
}
