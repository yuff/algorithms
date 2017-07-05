package com.leetcode.mytest;

/**
 * 
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3,
 * 12, 0, 0].
 * 
 * Note: You must do this in-place without making a copy of the array. Minimize the total number of
 * operations.
 *
 */
public class MoveZeros {
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 5, 0, 0, 23, 12, 0, 5, 14, 0, 0, 26, 0};
		new MoveZeros().moveZeroes(nums);
		for(int i: nums) {
			System.out.println(i);
		}
	}
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length == 0) {
        	return;
        }
        int zeroStart = -1;
        for(int i = 0; i < length; i++) {
        	if (nums[i] == 0 ) {
        		if (zeroStart == -1) {    			
        			zeroStart = i;
        		} 
        	} else {
        		if (zeroStart != -1) {
        			nums[zeroStart++] = nums[i];
        			nums[i] = 0;
        		}
        	}
        }
    }
}
