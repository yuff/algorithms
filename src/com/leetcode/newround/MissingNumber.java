package com.leetcode.newround;

public class MissingNumber {

	public static void main(String[] args) {
		MissingNumber mn = new MissingNumber();
		int count = mn.findMissingNumber(new int[]{1, 3, 31,33}, Integer.MAX_VALUE);
		System.out.println(count);						
//		System.out.println(missing);						
	}
	
	public int findMissingNumber(int[] nums, int n) {
		int missing = 0, i = 0;
		long start = 1;
		while(start <= n) {
			if (i < nums.length && nums[i] <= start) {
				start += nums[i];
				i++;
			} else {
				start += start;
				missing++;
			}
		}
		return missing;
	}

}
