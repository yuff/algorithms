package com.leetcode.newround;

import com.java8.util.CommonUtil;

public class SearchForRange {
	public static void main(String[] args) {
		SearchForRange sf = new SearchForRange();
		int[] nums = new int[] {2, 3, 4, 4, 5,6, 8, 8, 8, 8, 8, 8,8, 9, 9, 9, 10};
		CommonUtil.print(sf.searchRange(nums, 8));
		CommonUtil.print(sf.searchRange(nums, 2));
		CommonUtil.print(sf.searchRange(nums, 10));
	}

	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[] {-1, -1};
		}
		int[] result = new int[] {-1, -1};
		int[] ids = searchTarget(nums, target);
		if (ids[2] != -1) {
			result[0] = searchStart(nums, ids[0], ids[2], target);
			result[1] = searchEnd(nums, ids[2], ids[1], target);
		}
		return result;
	}

	private int[] searchTarget(int[] nums, int target) {
		int[] result = new int[3];
		result[2] = -1;
		int start = 0, end = nums.length;
		while (start < end) {
			int mid = (start + end) >> 1;
			if (nums[mid] == target) {
				result[0] = start;
				result[1] = end;
				result[2] = mid;
				break;
			}
			else if (nums[mid] > target) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		return result;
	}

	private int searchStart(int[] nums, int start, int end, int target) {
		while (start < end) {
			int mid = (start + end) >> 1;
			if (nums[mid] == target) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		return start;
	}

	private int searchEnd(int[] nums, int start, int end, int target) {
		while (start < end) {
			int mid = (start + end) >> 1;
			if (nums[mid] == target) {
				start = mid + 1;
			}
			else {
				end = mid;
			}
		}
		return end - 1;
	}
}
