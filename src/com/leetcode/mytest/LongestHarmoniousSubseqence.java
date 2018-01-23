package com.leetcode.mytest;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubseqence {
	public static void main(String[] args) {
		LongestHarmoniousSubseqence lhs = new LongestHarmoniousSubseqence();
		System.out.println(lhs.findLHS(new int[] {1, 3, 2, 2, 5, 2, 3, 7}));
	}

	public int findLHS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.get(num) == null) {
				map.put(num, 1);
			}
			else {
				map.put(num, map.get(num) + 1);
			}
		}
		int max = 0;
		for (int key : map.keySet()) {
			int count = map.get(key);
			int less = count, more = count;
			if (map.get(key - 1) != null) {
				less += map.get(key - 1);
				if (less > max) {
					max = less;
				}
			}
			if (map.get(key + 1) != null) {
				more += map.get(key + 1);
				if (more > max) {
					max = more;
				}
			}
		}
		return max;
	}
}
