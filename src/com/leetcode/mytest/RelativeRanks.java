package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * given scores of N athletes, find their relative ranks and the people with the top three highest
 * scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * 
 * Example 1: Input: [5, 4, 3, 2, 1] Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4",
 * "5"] Explanation: The first three athletes got the top three highest scores, so they got "Gold
 * Medal", "Silver Medal" and "Bronze Medal". For the left two athletes, you just need to output
 * their relative ranks according to their scores. Note: N is a positive integer and won't exceed
 * 10,000. All the scores of athletes are guaranteed to be unique.
 *
 *
 */
public class RelativeRanks {
	public static void main(String[] args) {
		RelativeRanks rr = new RelativeRanks();
		int[] nums = {5,4,8,6,3,2,1,10};
		String[] result = rr.findRelativeRanks1(nums);
		for(String s: result) {
			System.out.println(s);
		}
	}
	public String[] findRelativeRanks1(int[] nums) {
		int length = nums.length;
		int[] tmp = new int[length];
		System.arraycopy(nums, 0, tmp, 0, length);
		Arrays.sort(tmp);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			map.put(tmp[i], length - 1 - i);
		}
		String[] result = new String[length];
		for (int i = 0; i < length; i++) {
			int val = map.get(nums[i]);
    		if (val == 0) {
    			result[i] = "Gold Medal";
    		} else if (val == 1) {
    			result[i] = "Silver Medal";
    		} else if (val == 2) {
    			result[i] = "Bronze Medal";
    		} else {    			
    			result[i] = (val + 1) + "";
    		}
		}
		return result;
	}
    public String[] findRelativeRanks(int[] nums) {
    	int length = nums.length;
    	int[] result = new int[length];
    	for (int i = 0; i < length; i++) {
    		insertNum(nums, result, i);
    	}
    	String[] sResult = new String[length];
    	for (int i = 0; i < length; i++) {
    		if (result[i] == 0) {
    			sResult[i] = "Gold Medal";
    		} else if (result[i] == 1) {
    			sResult[i] = "Silver Medal";
    		} else if (result[i] == 2) {
    			sResult[i] = "Bronze Medal";
    		} else {    			
    			sResult[i] = (result[i] + 1) + "";
    		}
    	}
		return sResult;
    }

	private void insertNum(int[] nums, int[] result, int index) {
		if (index == 0) {
			result[0] = 0;
		} else {
			int start = index;
			for (int i = 0; i < index; i++) {
				if (nums[index] > nums[i]) {
					if (result[i] < start) {
						start = result[i];
					}
				}
			}
			reArray(result, start, index);
		}
	}

	private void reArray(int[] result, int realPos, int index) {
		result[index] = realPos;
		if (index == realPos) {
			return;
		}
		for (int i = 0; i < index; i++) {
			if (result[i] >= realPos) {
				result[i] = result[i] + 1;
			}
		}
	}
}
