package com.datastructure.dynamicprogramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LongestIncreaseSubsequencePrint {
	public static void main(String[] args) {
		LongestIncreaseSubsequencePrint lis = new LongestIncreaseSubsequencePrint();
		System.out.println(lis.lcs(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
	}

	public List<Integer> lcs(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<Integer>();
		}
		int n = nums.length;
		int[] lcsLen = new int[n];
		int[] index = new int[n];
		lcsLen[0] = 1;
		index[0] = -1;
		int res = 1, rId = 0;
		for (int i = 1; i < n; i++) {
			int max = 0, id = -1;
			for (int j = 0; j < i; j++) {
				if (nums[j] <= nums[i] && lcsLen[j] > max) {
					max = lcsLen[j];
					id = j;
				}
			}
			lcsLen[i] = max + 1;
			index[i] = id;
			if (lcsLen[i] > res) {
				res = lcsLen[i];
				rId = i;
			}
		}
		LinkedList<Integer> list = new LinkedList<>();
		while (rId != -1) {
			list.push(nums[rId]);
			rId = index[rId];
		}
		return list;
	}
}
