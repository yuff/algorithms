package com.leetcode.mytest;

public class SubarrayProductLessThanK {
	public static void main(String[] args) {
		SubarrayProductLessThanK sp = new SubarrayProductLessThanK();
		System.out.println(sp.numSubarrayProductLessThanK(new int[] {1,1,1}, 1));
	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0) {
			return 0;
		}
		int n = nums.length, result = 0, prod = 1, left = 0;
		for (int i = 0; i < n; i++) {
            prod *= nums[i];
            while (prod >= k && left <= i) {
                prod /= nums[left];
                left++;
            }
            result += (i - left + 1);
		}
		return result;  
	}
}
