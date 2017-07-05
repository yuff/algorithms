package com.leetcode.mytest;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {
	public static void main(String[] args) {
		int[] nums1 = {};
		int[] nums2 = {};
		int[] result = new NextGreaterElement().nextGreaterElement(nums1, nums2);
		for(int i: result) {
			System.out.println(i);
		}
	}
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int findLength = findNums.length;
        int length = nums.length;
        int[] result = new int[findLength];
        if (length == 0) {
        	return result;
        }
       
        Map<Integer, Integer> positionMap = new HashMap<>();
        int endIndex = 0;
        int previous = nums[0];
        Integer[] nextGreater = new Integer[length];
		for(int i = 0; i < length ; i++ ) {
			int currentValue = nums[i];
        	positionMap.put(nums[i], i);
        	if (currentValue > previous) {
        		setNextGreater(currentValue, nums, nextGreater, endIndex);
        		endIndex = i;
        	} else {
        		endIndex = i;
        		previous = currentValue;
        	}
        }
		for(int i = 0; i < length; i++) {
			if (nextGreater[i] == null) {
				nextGreater[i] = -1;
			}
		}
		for(int i = 0; i < findLength; i++) {
			int position = positionMap.get(findNums[i]);
			result[i] = nextGreater[position];
		}
        return result;
    }

	private void setNextGreater(int currentValue, int[] nums, Integer[] nextGreater, int endIndex) {
		for (int i = 0; i <= endIndex; i++) {
			if (nextGreater[i] == null && nums[i] < currentValue) {
				nextGreater[i] = currentValue;
			}
		}
	}
}
