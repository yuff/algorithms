package com.leetcode.mytest;

import java.util.*;

public class FindKPairsWithSmallestSums {
	public static void main(String[] args) {
		FindKPairsWithSmallestSums fp = new FindKPairsWithSmallestSums();
		int[] nums1 = new int[] {-10, -4, 0, 0, 6};
		int[] nums2 = new int[] {3, 5, 6, 7, 8, 100};
		int k = 10;
		List<int[]> result = fp.kSmallestPairs(nums1, nums2, k);
		for (int[] r : result) {
			System.out.print("[" + r[0] + "," + r[1] + "],");
		}
	}

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<>();
		if (nums1 == null || nums2 == null || k == 0 || nums1.length == 0 || nums2.length == 0) {
			return result;
		}
		int m = nums1.length, n = nums2.length;
		int i = 0, j = 0, count = k;
		result.add(new int[] {nums1[0], nums2[0]});
		int[] id1s = new int[m], id2s = new int[n];
		id1s[0] = 1;
		id2s[0] = 1;
		count--;
		while (i < m && j < n && count > 0) {
			int t1 = Integer.MAX_VALUE, t2 = t1, id1 = id1s[i], id2 = id2s[j];
			while (id1 == n && i < m - 1) {
				i++;
				id1 = id1s[i];
			}
			if (id1 == n) {
				break;
			}
			while (id2 == m && j < n - 1) {
				j++;
				id2 = id2s[j];
			}
			if (id2 == m) {
				break;
			}
			int[] tmp = findMin(nums1, i, id1s, nums2, j, id2s);
			result.add(new int[] {nums1[tmp[0]], nums2[tmp[1]]});
			id1s[tmp[0]] = tmp[1] + 1;
			id2s[tmp[1]] = tmp[0] + 1;
			count--;
		}
		return result;
	}

	private int[] findMin(int[] nums1, int s1, int[] id1s, int[] nums2, int s2, int[] id2s) {
		int min = Integer.MAX_VALUE;
		int[] result = new int[2];
		for (int i = s1; i < nums1.length; i++) {
			int j = id1s[i];
			int t = nums1[i] + nums2[j];
			if (t < min) {
				min = t;
				result[0] = i;
				result[1] = j;
			}
		}
		
		for(int j = s2; j < nums2.length; j++) {
			int i = id2s[j];
			int t = nums1[i] + nums2[j];
			if (t < min) {
				min = t;
				result[0] = i;
				result[1] = j;
			}
		}
		return result;
	}
}
