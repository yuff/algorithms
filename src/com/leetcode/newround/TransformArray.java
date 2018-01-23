package com.leetcode.newround;

import java.util.Arrays;

import com.java8.util.CommonUtil;

/**
 * 
 * Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function
 * of the form f(x) = ax2 + bx + c to each element x in the array. The returned array must be
 * in sorted order. Expected time complexity: O(n)
 * 
 * Example: nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
 * 
 * Result: [3, 9, 15, 33]
 * 
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
 * 
 * Result: [-23, -5, 1, 7]
 *
 */
public class TransformArray {
	public static void main(String[] args) {
		TransformArray tfa = new TransformArray();
		int[] nums = new int[] {9,12,13};
		CommonUtil.print(tfa.sortTransformedArray(nums, -2, 44, -56));
//		CommonUtil.print(tfa.sortTransformedArray(nums, -49, -100, 1000));
	}

	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		int[] result = new int[nums.length];
		int splitId = Arrays.binarySearch(result, findSplitId(a, b));
		splitId = splitId < 0? -splitId: splitId;
		result = merge(transformArr(nums, a, b, c, 0, splitId),transformArr(nums, a, b, c, splitId, nums.length));
		return result;
	}

	public int[] transformArr(int[] nums, int a, int b, int c, int start, int end) {
		if (start == end) {
			return new int[0];
		}
		int[] mArr = new int[end - start];
		for (int i = start; i < end; i++) {
			mArr[i - start] = a * nums[i] * nums[i] + b * nums[i] + c;
		}
		int i = 0, j = end - start - 1;
		if (mArr[i] > mArr[j]) {
			while (i < j) {
				int t = mArr[i];
				mArr[i] = mArr[j];
				mArr[j] = t;
				i++;
				j--;
			}
		}
		return mArr;
	}


	private int[] merge(int[] mArr, int[] pArr) {
		int m = mArr.length, p = pArr.length;
		if (m == 0) {
			return pArr;
		}
		if (p == 0) {
			return mArr;
		}
		int i = 0, j = 0, k = 0;
		int[] result = new int[m + p];
		while (i < m && j < p) {
			if (mArr[i] < pArr[j]) {
				result[k++] = mArr[i++];
			}
			else {
				result[k++] = pArr[j++];
			}
		}
		while (i < m) {
			result[k++] = mArr[i++];
		}
		while (j < p) {
			result[k++] = pArr[j++];
		}
		return result;
	}

	private int findSplitId(int a, int b) {
		int split = (int)(Math.sqrt(Math.abs(b)) / (2 * Math.sqrt(Math.abs(a))));
		return a < 0 ? split: - split;
	}
	private int findSplitId(int[] nums) {
		int id = nums.length;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num > 0) {
				id = i;
				break;
			}
		}
		return id;
	}
}
