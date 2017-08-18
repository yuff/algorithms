package com.leetcode.mytest;

public class FindTheDuplicatedNumber {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
        	return 0;
        }
        int len = nums.length;
        int result = 0;
        for(int i = 1; i < len; i++) {
        	int count = 0;
        	for(int j = 0; j < len; j++) {
        		int tmp = nums[j] ^ i;
        		if ( tmp == 0) {
        			count++;
        			if (count > 1) {
        				return nums[j];
        			}
        		}
        	}
        }
        return result;
    }
}
