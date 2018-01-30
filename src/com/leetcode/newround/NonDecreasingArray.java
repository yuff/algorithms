package com.leetcode.newround;

public class NonDecreasingArray {
	public static void main(String[] args) {
		NonDecreasingArray nd = new NonDecreasingArray();
		System.out.println(nd.checkPossibility(new int[]{-1,4,2,3}));
	}
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int n = nums.length, count = 0;
        for(int i = 1; i < n && count < 2; i++) {
            if (nums[i  - 1]  > nums[i]) {
                count++;
                if (i < 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                	nums[i] = nums[i - 1];
                }
            }
        }
        return count <= 1;
    }
}
