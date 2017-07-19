package com.datastructure.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreaseSubsquence {
	public static void main(String[] args) {
		LongestIncreaseSubsquence lis = new LongestIncreaseSubsquence();
		int[] nums = new int[] {5, 6, 7, 8, 1, 2, 4, 5};
		// int[] result = lis.longestIncreaseSubsquence(nums);
		// for (int i : result) {
		// System.out.print(i);
		// System.out.print(",");
		// }

		List<int[]> rList = lis.allLongestIncreaseSubsequence(nums);
		for (int[] r : rList) {
			for (int i : r) {
				System.out.print(i);
				System.out.print(",");
			}
			System.out.println();
		}
	}

	public List<int[]> allLongestIncreaseSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<int[]>();
		}
		int length = nums.length;
		int[] lenArray = new int[length];
		lenArray[0] = 1;
		int maxLen = 1;
		for (int i = 1; i < length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (lenArray[j] > max && nums[i] > nums[j]) {
					max = lenArray[j];
				}
			}
			lenArray[i] = max + 1;
			if (lenArray[i] > maxLen) {
				maxLen = lenArray[i];
			}
		}
		return printAll(nums, lenArray, maxLen);
	}

	private List<int[]> printAll(int[] nums, int[] lenArray, int maxLen) {
		List<int[]> result = new ArrayList<>();
		int[] tmp = new int[maxLen];
		int length = nums.length;
		print(result, tmp, nums, lenArray, maxLen, length);
		return result;
	}

	private void print(List<int[]> result, int[] tmp, int[] nums, int[] lenArray, int length, int index) {
		if (length == 0) {
			int l = tmp.length;
			int[] r = new int[l];
			System.arraycopy(tmp, 0, r, 0, l);
			result.add(r);
			return;
		}
		int value = Integer.MAX_VALUE;
		if (index < nums.length) {
			value = nums[index];
		}
		for (int i = index - 1; i >= 0; i--) {
			if (lenArray[i] == length && nums[i] < value) {
				tmp[length - 1] = nums[i];
				print(result, tmp, nums, lenArray, length - 1, i);
			}
		}

	}

	public int[] longestIncreaseSubsquence(int[] nums) {
		if (nums == null || nums.length == 1) {
			return nums;
		}
		int length = nums.length;
		int[] len = new int[length];
		int[] result = new int[length];
		len[0] = 1;
		result[0] = 0;
		int maxLen = 1;
		int maxIndex = 0;
		for (int i = 1; i < length; i++) {
			int max = 0;
			int index = i;
			for (int j = 0; j < i; j++) {
				if (len[j] > max && nums[j] < nums[i]) {
					max = len[j];
					index = j;
				}
			}
			len[i] = max + 1;
			result[i] = index;
			if (len[i] > maxLen) {
				maxLen = len[i];
				maxIndex = i;
			}
		}
		int[] sub = new int[maxLen];
		int curIndex = maxLen - 1;
		while (curIndex >= 0) {
			sub[curIndex] = nums[maxIndex];
			maxIndex = result[maxIndex];
			curIndex--;
		}
		return sub;
	}
}
