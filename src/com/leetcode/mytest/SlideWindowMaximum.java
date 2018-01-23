package com.leetcode.mytest;

public class SlideWindowMaximum {
	public static void main(String[] args) {
		SlideWindowMaximum sw = new SlideWindowMaximum();
		int[] result = sw.maxSlidingWindow(new int[] {9, 10, 9, -7, -4, -8, 2, -6}, 3);
		for (int r : result) {
			System.out.print(r + ",");
		}
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || nums.length < k) {
			return new int[0];
		}
		if (k == 1) {
			return nums;
		}
		int n = nums.length;
		int[] result = new int[n - k + 1];
		int maxId = nums[1] >= nums[0] ? 1 : 0, secondId = maxId == 0 ? 1 : 0;
		for (int i = 2; i < k; i++) {
			if (nums[i] >= nums[maxId]) {
				int tmp = maxId;
				maxId = i;
				secondId = tmp;
			}
			else if (nums[i] >= nums[secondId]) {
				secondId = i;
			}
		}
		int j = 1, abandon = 0;
		result[0] = nums[maxId];
		for (int i = k; i < n; i++) {
			if (nums[i] >= result[j - 1]) {
				result[j] = nums[i];
				int tmp = maxId;
				maxId = i;
				if (tmp != abandon) {
					secondId = tmp;
				}
			}
			else {
				if (maxId != abandon) {
					result[j] = result[j - 1];
				}
				else {
					int[] tmp = findSecondId(nums, i, k);
					result[j] = nums[tmp[0]];
					maxId = tmp[0];
					secondId = tmp[1];
				}

			}
			j++;
			abandon++;
		}
		return result;
	}

	private int[] findSecondId(int[] nums, int i, int k) {
		int maxId = nums[i] >= nums[i - 1] ? i : i - 1, secondId = maxId == i ? i - 1 : i;
		for (int j = i - 2; j > i - k; j--) {
			if (nums[j] >= nums[maxId]) {
				int tmp = maxId;
				maxId = j;
				secondId = tmp;
			}
			else if (nums[j] >= nums[secondId]) {
				secondId = j;
			}
		}
		return new int[] {maxId, secondId};
	}
}
