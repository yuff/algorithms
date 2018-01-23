package com.leetcode.mytest;

import com.java8.util.CommonUtil;

public class NextPermutation {
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] nums = new int[] {2, 3, 1};
		int[] nums1 = new int[] {3, 2, 1};
		int[] nums2 = new int[] {2, 3, 1};
		int[] nums3 = new int[] {2, 9, 8, 7, 4};
		np.nextPermutation(nums);
		np.nextPermutation(nums1);
		np.nextPermutation(nums2);
		np.nextPermutation(nums3);
		CommonUtil.print(nums);
		CommonUtil.print(nums1);
		CommonUtil.print(nums2);
		CommonUtil.print(nums3);
	}

	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 1) {
			return;
		}
		int n = nums.length;
		int pre = nums[n - 1];
		int i = n - 2;
		while (i >= 0 && pre <= nums[i]) {
			pre = nums[i];
			i--;
		}
		if (i >= 0) {
			int tmp = nums[i];
			int j = n - 1;
			while (j > i && nums[j] <= tmp) {
				j--;
			}
			nums[i] = nums[j];
			nums[j] = tmp;
			switchNum(nums, i + 1, n - 1);
		}
		else {
			switchNum(nums, 0, n - 1);
		}
	}

	private void switchNum(int[] nums, int s, int e) {
		int i = s, j = e;
		while (i < j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}

	}
}
