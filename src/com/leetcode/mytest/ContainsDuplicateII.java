package com.leetcode.mytest;

import java.util.Arrays;
import java.util.Comparator;

public class ContainsDuplicateII {
	public static void main(String[] args) {
		ContainsDuplicateII cd = new ContainsDuplicateII();
		int[] nums = new int[] {1, 2, 3,8, 1, 4, 5};
		System.out.println(cd.containsNearbyDuplicate(nums, 3));
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int n = nums.length;
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = nums[i];
			arr[i][1] = i;
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				else {
					return o1[0] - o2[0];
				}
			}
		});
		for (int i = 1; i < n; i++) {
			if (arr[i][0] == arr[i - 1][0] && arr[i][1] - arr[i - 1][1] <= k) {
				return true;
			}
		}
		return false;
	}
}
