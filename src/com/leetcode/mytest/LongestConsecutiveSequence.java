package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		Map<Integer, Boolean> map = new HashMap<>();
		map.put(1, true);
		if (map.get(2) != null) {
			System.out.println(map.get(2));
		}
		else {
			System.out.println("not exist");
		}
		int[] array = {56, 8, 5, 4, 57, 532, 59, 58, 55};
		System.out.println(findLongestCS(array));
		int[] arr1 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
		System.out.println(findLongestCS(arr1));
	}

	public static int findLongestCS(int[] nums) {
		Map<Integer, Boolean> map = new HashMap<>();
		for (Integer i : nums) {
			map.put(i, true);
		}
		int arrayLength = nums.length;
		int currentLen = 0;
		int longestLen = 0;
		for (Integer i : map.keySet()) {
			if (map.get(i)) {
				currentLen++;
				int needMinus = 0;
				for (int index = 1; index <= arrayLength; index++) {
					if (map.get(i + index) != null && map.get(i + index)) {
						currentLen++;
						needMinus++;
						map.put(i + index, false);
					}
					else {
						arrayLength -= needMinus;
						break;
					}
				}
				needMinus = 0;
				for (int index = 1; index <= arrayLength; index++) {
					if (map.get(i - index) != null && map.get(i - index)) {
						currentLen++;
						map.put(i - index, false);
					}
					else {
						arrayLength -= needMinus;
						break;
					}
				}
				if (currentLen > longestLen) {
					longestLen = currentLen;
				}
				currentLen = 0;
			}
		}
		if (currentLen > longestLen) {
			longestLen = currentLen;
		}
		return longestLen;
	}
}
