package com.leetcode.mytest;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without
 * using extra memory?
 *
 */
public class SingleNumber {

	public int singleNumber1(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return 0;
		}
		int result = nums[0];
		for (int i = 1; i < length; i++) {
			result = result ^ nums[i];
		}
		return result;
	}

	public int singleNumber(int[] nums) {
		Map<Integer, Boolean> flag = new HashMap<>();
		for (int num : nums) {
			if (flag.get(num) != null) {
				flag.put(num, true);
			}
			else {
				flag.put(num, false);
			}
		}
		for (int key : flag.keySet()) {
			if (!flag.get(key)) {
				return key;
			}
		}
		return 0;
	}
}
