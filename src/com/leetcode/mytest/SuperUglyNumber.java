package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperUglyNumber {
	public static void main(String[] args) {
		SuperUglyNumber sun = new SuperUglyNumber();
		// System.out.println(sun.nthSuperUglyNumber(120, new int[] {2, 7, 13, 19}));
		System.out.println(sun.nthSuperUglyNumber(12,
		                                          new int[] {2, 7, 13, 19}));
	}

	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n == 1) {
			return 1;
		}
		int k = primes.length;
		int[] index = new int[k];
		int[] nums = new int[k];
		for (int i = 0; i < k; i++) {
			nums[i] = primes[i];
		}
		int[] result = new int[n];
		result[0] = 1;
		for (int i = 1; i < n; i++) {
			findNext(index, nums, primes, result, i);
		}
		return result[n - 1];
	}

	private void findNext(int[] index, int[] nums, int[] primes, int[] result, int i) {
		List<Integer> ids = findMinIds(nums);
		result[i] = nums[ids.get(0)];
		for(int id: ids) {			
			index[id] += 1;
			int next = result[index[id]] * primes[id];
			nums[id] = next;
		}
	}

	private List<Integer> findMinIds(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int n = nums.length, r = 0;
		result.add(r);
		for (int i = 1; i < n; i++) {
			if (nums[i] < nums[r]) {
				result.clear();
				r = i;
				result.add(r);
			} else if (nums[i] == nums[r]) {
				result.add(i);
			}
		}
		return result;
	}
	// public int nthSuperUglyNumber(int n, int[] primes) {
	// int num = 1;
	// int index = 0;
	// int[] list = new int[n];
	// Map<Integer, Boolean> map = new HashMap<>();
	// list[0] = 1;
	// int i = 1;
	// map.put(1, true);
	// while (i < n) {
	// num++;
	// if (index < primes.length && primes[index] == num) {
	// list[i++] = num;
	// index++;
	// map.put(num, true);
	// }
	// else if (isUglyNumber(num, map, primes)) {
	// list[i++] = num;
	// }
	// }
	// return list[n - 1];
	// }
	//
	// private boolean isUglyNumber(int num, Map<Integer, Boolean> map, int[] primes) {
	// for (int p : primes) {
	// if (num % p == 0 && map.get(num / p) != null) {
	// return true;
	// }
	// }
	// return false;
	// }

}
