package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicated {
	public static void main(String[] args) {
		FindDuplicated fd = new FindDuplicated();
		int[] nums = new int[]{4,3,2,7,8,2,3,1};
		List<Integer> result = fd.findDuplicates(nums);
		System.out.println(result);
	}
	  public List<Integer> findDuplicates(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return new ArrayList<Integer>();
	        }
	        int length = nums.length;
	        for(int i = 0; i < length; i++) {
	            int value = nums[i];
	            if (value <= 0) {
	                continue;
	            } else {
	                nums[i] = 0;  
	                while (value > 0) {
	                    int tmp = nums[value - 1];
	                    if (tmp < 0) {
	                        nums[value - 1] = tmp - 1;
	                    } else {
	                    	nums[value - 1] = -1;
	                    }
	                    value = tmp;     
	                }
	            }
	        }
	        List<Integer> result = new ArrayList<>();
	        for(int i = 0; i < length; i++) {
	            if (nums[i] == -2) {
	                result.add(i + 1);
	            }
	        }
	        return result;
	    }
}
