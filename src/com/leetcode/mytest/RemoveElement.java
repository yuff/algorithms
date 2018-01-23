package com.leetcode.mytest;

public class RemoveElement {
	public static void main(String[] args) {
		RemoveElement re = new RemoveElement();
		System.out.println(re.removeElement(new int[] {1, 2, 3, 3, 1, 1, 4}, 1));
	}

	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int start = 0, end = n - 1;
		while (end >= 0 && nums[end] == val) {
			end--;
		}
		if (end < 0) {
			return 0;
		}
		while (start < end) {
			if (nums[start] != val) {
				start++;
			}
			else {
				nums[start] = nums[end];
				nums[end] = val;
				end--;
				while (nums[end] == val && end >= start) {
					end--;
				}
			}
		}
		return start + 1;
	}
}
