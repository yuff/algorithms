package com.leetcode.newround;

import java.util.Arrays;

import com.java8.util.CommonUtil;

public class WiggleSortII {
	public static void main(String[] args) {
		WiggleSortII ws = new WiggleSortII();
		int[] nums = new int[]{4,5,5,6};
		ws.wiggleSort(nums );
		CommonUtil.print(nums);
	}
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        Arrays.sort(nums);
        int[] tmp = new int[nums.length];
        System.arraycopy(nums,0,tmp,0, nums.length);
        int mid = (nums.length + 1) / 2, small = mid - 1, large = nums.length - 1, i = 0;
        while (small >= 0 && large >= mid) {
            nums[i++] = tmp[small--];
            nums[i++] = tmp[large--];
        }
        while (small >= 0) {
            nums[i++] = tmp[small--];
        }  
        while (large >= mid) {
            nums[i++] = tmp[large--];
        }
    }
}
