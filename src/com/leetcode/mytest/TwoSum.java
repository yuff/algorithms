package com.leetcode.mytest;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers that is already sorted in ascending order, find two numbers such that
 * they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and
 * index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution and you may not use the same
 * element twice.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 *
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] numbers = {2,3,4};
		int[] result = new TwoSum().twoSum(numbers, 6);
		for (int r : result) {
			System.out.println(r);
		}
	}

	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.get(numbers[i]) != null && target == 2 * (numbers[i])) {
				result[0] = map.get(numbers[i]) + 1;
				result[1] = i + 1;
				return result;
			}
			map.put(numbers[i], i);
		}
		for (int i = 0; i < numbers.length; i++) {
			int another = target - numbers[i];
			if (another != numbers[i] && map.get(another) != null) {
				int index = map.get(another);
				result[0] = i + 1;
				result[1] = index + 1;
				break;
			}
		}
		return result;
	}
}
