package com.leetcode.newround;

import com.java8.util.CommonUtil;

public class RemoveDuplicatedFromSortedArray {
	public static void main(String[] args) {
		RemoveDuplicatedFromSortedArray rd = new RemoveDuplicatedFromSortedArray();
		int[] nums = new int[] {1, 1, 2, 3, 4, 4, 4, 5, 5, 6, 6, 6, 8, 9, 10, 10, 10};
		System.out.println(rd.removeDuplicates(nums));
		CommonUtil.print(nums);
	}

	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int pre = nums[0], id = 1, i = 1, n = nums.length;
		while (i < n) {
			int cur = nums[i];
			if (cur != pre) {
				nums[id++] = cur;
				pre = cur;
			}
			i++;
		}
		return id;
	}
}
