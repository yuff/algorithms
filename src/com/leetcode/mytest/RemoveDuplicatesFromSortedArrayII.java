package com.leetcode.mytest;

public class RemoveDuplicatesFromSortedArrayII {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayII rd = new RemoveDuplicatesFromSortedArrayII();
		int[] nums1 = new int[] {1, 1, 1, 2};
		int[] nums2 = new int[] {1, 1, 1, 2, 3, 3, 4, 4, 4, 4, 5};
		System.out.println(rd.removeDuplicates(nums1));
		System.out.println(rd.removeDuplicates(nums2));
		for(int i: nums1) {
			System.out.print(i + ",");
		}
		System.out.println();
		for(int i: nums2) {
			System.out.print(i + ",");
		}
	}

	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = 0, pre = nums[0], count = 1, n = nums.length, id = 0;
		for (int i = 1; i < n; i++) {
			if (nums[i] == pre) {
				count++;
			}
			else {
				int tmp = count >= 2 ? 2 : count;
				result += tmp;
				if (id == 0) {
					id = tmp;
				} else {					
					id = exchange(nums, i - 1, tmp, id);
				}
				count = 1;
				pre = nums[i];
			}
		}
		int tmp = count >= 2 ? 2 : count;
		result += tmp;
		exchange(nums, n - 1, tmp, id);
		return result;
	}

	private int exchange(int[] nums, int i, int count, int id) {
		while(count > 0) {
			int t = nums[id];
			nums[id] = nums[i];
			nums[i] = t;
			id++;
			i--;
			count--;
		}
		return id;
	}
}
