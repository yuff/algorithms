package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CountOfSmallerNumbersAfterSelf {
	public static void main(String[] args) {
		CountOfSmallerNumbersAfterSelf cs = new CountOfSmallerNumbersAfterSelf();
		int[] nums = new int[40000];
		Random random = new Random();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt();
		}
		 System.out.println(cs.countSmaller(new int[] {5, 2, 6, 1}));
		System.out.println(cs.countSmaller(nums));
	}

	public List<Integer> countSmaller(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<Integer>();
		}
		int n = nums.length;
		int[] counts = new int[n];
		counts[n - 1] = 0;
		LinkedList<Integer> list = new LinkedList<>();
		list.add(nums[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			int value = nums[i];
			int count = findLessNum(list, value);
			counts[i] = count;
		}
		List<Integer> result = new ArrayList<>();
		for (int c : counts) {
			result.add(c);
		}
		return result;
	}

	private int findLessNum(LinkedList<Integer> list, int value) {
		int left = 0, right = list.size() - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (list.get(mid) == value) {
				mid--;
				while (mid >= 0 && list.get(mid) == value) {
					mid--;
				}
				list.add(mid + 1, value);
				return mid + 1;
			}
			else if (list.get(mid) > value) {
				if (mid == 0) {
					list.add(0, value);
					return 0;
				}
				else if (list.get(mid - 1) < value) {
					list.add(mid, value);
					return mid;
				}
				else {
					right = mid - 1;
				}
			}
			else {
				if (mid == list.size() - 1) {
					int size = list.size();
					list.add(size, value);
					return size;
				}
				else {
					if (list.get(mid + 1) > value) {
						list.add(mid + 1, value);
						return mid + 1;
					}
					else {
						left = mid + 1;
					}
				}
			}
		}
		list.add(right, value);
		return right;
	}
	// public List<Integer> countSmaller1(int[] nums) {
	// if (nums == null || nums.length == 0) {
	// return new ArrayList<Integer>();
	// }
	// int n = nums.length;
	// int[] counts = new int[n];
	// counts[n - 1] = 0;
	// Map<Integer, List<Integer>> map = new HashMap<>();
	// for (int i = 0; i < n; i++) {
	// if (map.get(nums[i]) == null) {
	// map.put(nums[i], new ArrayList<>());
	// }
	// map.get(nums[i]).add(i);
	// }
	// List<Integer> list = new ArrayList<>(map.keySet());
	// Collections.sort(list);
	// List<Integer> f = map.get(list.get(0));
	// for (int i : f) {
	// counts[i] = 0;
	// }
	// int size = list.size();
	// List<Integer> all = new ArrayList<>();
	// for (int i = 1; i < size >> 1; i++) {
	// List<Integer> index = map.get(list.get(i));
	// all.addAll(map.get(list.get(i - 1)));
	// Collections.sort(all);
	// int pre = countLessNum(all, index.get(0), -1, counts);
	// for (int j = 1; j < index.size(); j++) {
	// int id = index.get(j);
	// pre = countLessNum(all, id, pre, counts);
	// }
	// }
	// List<Integer> all1 = new ArrayList<>();
	// for (int i = size - 1; i >= size >> 1; i--) {
	// List<Integer> index = map.get(list.get(i));
	// all1.addAll(map.get(list.get(i)));
	// Collections.sort(all1);
	// for (int j : index) {
	// int id = Collections.binarySearch(all1, j);
	// counts[j] = n - j - 1 - (all1.size() - id - 1);
	// }
	// }
	// List<Integer> result = new ArrayList<>();
	// for (int c : counts) {
	// result.add(c);
	// }
	// return result;
	// }
	//
	// private int countLessNum(List<Integer> list, int id, int pre, int[] counts) {
	// int left = Math.max(0, pre), right = list.size() - 1;
	// while (left <= right) {
	// int mid = (left + right) >> 1;
	// if (list.get(mid) < id) {
	// if (mid + 1 == list.size()) {
	// counts[id] = 0;
	// return mid;
	// }
	// else if (list.get(mid + 1) > id) {
	// counts[id] = list.size() - (mid + 1);
	// return mid + 1;
	// }
	// else {
	// left = mid + 1;
	// }
	// }
	// else if (list.get(mid) > id) {
	// if (mid == 0) {
	// counts[id] = list.size();
	// return 0;
	// }
	// else if (list.get(mid - 1) < id) {
	// counts[id] = list.size() - mid;
	// return mid;
	// }
	// else {
	// right = mid - 1;
	// }
	// }
	// }
	// counts[id] = 0;
	// return right;
	// }
}
