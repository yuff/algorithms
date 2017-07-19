package com.leetcode.mytest;

public class SingleElementInASortedArray {

	public static void main(String[] args) {
		SingleElementInASortedArray sa = new SingleElementInASortedArray();
		int[] nums = new int[] {1, 1, 2, 2, 4, 4, 5, 5,9};
		System.out.println(sa.singleNonDuplicateLgn(nums));
	}

	public int singleNonDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			throw new RuntimeException("error input");
		}
		int result = nums[0];
		int pre = nums[0];
		boolean hasTwo = false;
		int len = nums.length;
		for (int i = 1; i < len; i++) {
			if (!hasTwo && nums[i] == pre) {
				hasTwo = true;
				pre = nums[i];
			}
			else if (hasTwo) {
				pre = nums[i];
				hasTwo = false;
			}
			else {
				result = pre;
				break;
			}
		}
		return result;
	}

	public int singleNonDuplicateLgn(int[] nums) {
		if (nums == null || nums.length == 0) {
			throw new RuntimeException("error input");
		}
		int len = nums.length;
		return findSingle(nums, 0, len - 1);
	}

	private int findSingle(int[] nums, int start, int end) {
		int mid = (start + end) >> 1;
		if (mid == start || mid == end) {
			return nums[mid];
		}
		else if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
			return nums[mid];
		}
		else {
			int result = 0;
			if (mid % 2 == 0) {
				if (nums[mid] == nums[mid - 1]) {
					result = findSingle(nums, start, mid);
				} else {
					result = findSingle(nums, mid, end);
				}
			} else {
				if (nums[mid] == nums[mid - 1]) {
					result = findSingle(nums, mid, end);
				} else {
					result = findSingle(nums, start, mid);
				}
			}
			return result;
		}

	}
}
