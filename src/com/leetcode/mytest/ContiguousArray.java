package com.leetcode.mytest;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public static void main(String[] args) {
		ContiguousArray ca = new ContiguousArray();
		System.out.println(ca.findMaxLength(new int[] {0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0}));
	}

	public int findMaxLength(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				nums[i] = -1;
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (map.get(sum) != null) {
				max = Math.max(max, i - map.get(sum));
			}
			else {
				map.put(sum, i);
			}
		}
		return max;
	}

	public int findMaxLength1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int count0 = 0;
		int count1 = 0;
		Map<Integer, Integer> index0 = new HashMap<>();
		Map<Integer, Integer> index1 = new HashMap<>();
		int[] max = new int[n];
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				count0++;
				index0.put(count0, i);
			}
			else if (nums[i] == 1) {
				count1++;
				index1.put(count1, i);
			}
			if (count0 < count1) {
				max[i] = findMax(index0, count0);
			}
			else {
				max[i] = findMax(index1, count1);
			}
			if (max[i] > result) {
				result = max[i];
			}
		}
		return result;
	}

	private int findMax(Map<Integer, Integer> map, int count) {
		if (count == 0) {
			return 0;
		}
		if (count == 1) {
			return 2;
		}
		int id = map.get(count);
		for (int i = 1; i < count; i++) {
			int len = (count - i + 1) * 2;
			int id1 = map.get(i);
			if (id - id1 < len) {
				return len;
			}
		}
		return 0;
	}
}
