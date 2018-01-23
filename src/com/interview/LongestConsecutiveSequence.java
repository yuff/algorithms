package com.interview;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int[] nums = new int[] {-7, -1, 3, -9, -4, 7, -3, 2, 4, 9, 4, -9, 8, -7, 5, -1,
		                        -7};
//		System.out.println(lcs.longestConsecutive(nums));
//		System.out.println(lcs.longestConsecutive(new int[] {}));
//		System.out.println(lcs.longestConsecutive(new int[] {1, 3, 2, 4, 6, 7, 9, 10, 55, 23,
//		                                                     8}));
//		System.out.println(lcs.longestConsecutive(new int[] {1}));
//		System.out.println(lcs.longestConsecutive(new int[] {2, 3, -1, 0}));
		System.out.println(lcs.longestConsecutive(new int[] {3, 2, 4, 4, 5}));
	}

	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length, max = 0;
		Map<Integer, int[]> map = new HashMap<>();
		Map<Integer, Boolean> process = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int value = nums[i];
			if (process.get(value) != null) {
				continue;
			}
			else {
				if (map.get(value - 1) != null && map.get(value + 1) != null) {
					int[] preRange = map.get(value - 1), nextRange = map.get(value + 1);
					if (preRange[1] == value - 1 && nextRange[0] == value + 1) {
						int[] newRange = new int[] {preRange[0], nextRange[1]};
						map.remove(value - 1);
						map.remove(value + 1);
						max = updateMax(max, map, newRange);
					}
				}
				else if (map.get(value - 1) != null) {
					int[] preRange = map.get(value - 1);
					if (preRange[1] == value - 1) {
						int[] newRange = new int[] {preRange[0], value};
						map.remove(value - 1);
						max = updateMax(max, map, newRange);
					}
				}
				else if (map.get(value + 1) != null) {
					int[] nextRange = map.get(value + 1);
					if (nextRange[0] == value + 1) {
						int[] newRange = new int[] {value, nextRange[1]};
						map.remove(value + 1);
						max = updateMax(max, map, newRange);
					}
				}
				else {
					int[] newRange = new int[] {value, value};
					max = updateMax(max, map, newRange);
				}
				process.put(value, true);
			}
		}
		return max;
	}

	public int updateMax(int max, Map<Integer, int[]> map, int[] newRange) {
		map.put(newRange[0], newRange);
		map.put(newRange[1], newRange);
		max = Math.max(newRange[1] - newRange[0] + 1, max);
		return max;
	}
}
