package com.leetcode.mytest;

public class SearchInRotatedSortedArrayII {
	public static void main(String[] args) {
		SearchInRotatedSortedArrayII sir = new SearchInRotatedSortedArrayII();
		System.out.println(sir.search(new int[]{4,5,6,7,0,1,2, 3,3,4}, 4));
		System.out.println(sir.search(new int[]{14,15,16,17,1,2,3,4,4,5,5,6,7,8,9,10,11,12,13,13,14}, 14));
	}
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
        	return false;
        }
        int pivot = findPivotId(nums);
        int n = nums.length;
        
        if (pivot == -1) {
        	return search(nums, 0, n - 1, target);
        }
		int mid = (0 + n - 1) >> 1;
		if (nums[mid] == target) {
			return true;
		} else if (nums[mid] > target) {
			if (pivot > mid) {
				boolean tmp = search(nums, 0, mid, target);
				if (tmp) {
					return true;
				} else {
					return search(nums, pivot, n - 1, target);
				}
			} else {
				return search(nums, pivot, mid, target);
			}
		} else {
			if (pivot > mid) {
				return search(nums, mid + 1, pivot - 1, target);
			} else {
				boolean tmp =  search(nums, mid + 1, n - 1, target);
				if (tmp) {
					return true;
				} else {
					return search(nums, 0, pivot - 1, target);
				}
			}
		}
    }


	private boolean search(int[] nums, int start, int end, int target) {
		if (start > end) 
		{
			return false;
		} else if (start == end) {
			return nums[start] == target? true : false;
		}
		int mid = (start + end) >> 1;
		if (nums[mid] == target) {
			return true;	
		} else if (nums[mid] > target) {
			return search(nums, start, mid, target);
		} else {
			return search(nums, mid + 1, end, target);
		}
	}

	private int findPivotId(int[] nums) {
		int n = nums.length, pre = nums[0];
		for(int i = 1; i < n; i++) {
			int cur = nums[i];
			if (cur < pre) {
				return i;
			} else {
				pre = cur;
			}
		}
		return -1;
	}
}
