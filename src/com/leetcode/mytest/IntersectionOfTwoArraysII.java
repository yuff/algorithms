package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {
	public static void main(String[] args) {
		IntersectionOfTwoArraysII it = new IntersectionOfTwoArraysII();
		int[] nums1 = new int[] {4, 1, 2, 2, 1};
		int[] nums2 = new int[] {2, 2, 1, 4, 6};
		int[] r = it.intersect(nums1, nums2);
		for (int i : r) {
			System.out.print(i);
			System.out.print(",");
		}
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> r = new ArrayList<>();
		int n1 = nums1.length;
		int n2 = nums2.length;
		int i = 0, j = 0;
		while (i < n1 && j < n2) {
			if (nums1[i] == nums2[j]) {
				r.add(nums1[i]);
				i++;
				j++;
			}
			else if (nums1[i] < nums2[j]) {
				i++;
			}
			else {
				j++;
			}
		}
		int[] result = new int[r.size()];
		int in = 0;
		for (int num : r) {
			result[in++] = num;
		}
		return result;
	}
}
