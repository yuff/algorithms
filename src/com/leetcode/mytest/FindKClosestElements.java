package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

import com.java8.util.CommonUtil;

public class FindKClosestElements {
	public static void main(String[] args) {
		FindKClosestElements fkc = new FindKClosestElements();
		List<Integer> arr = CommonUtil.convertToList(new int[] {0, 0, 1, 2, 3, 3, 4, 7, 7, 8});
		System.out.println(fkc.findClosestElements(arr, 3, 5));
	}

	public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
		int id = findMinId(arr, x);
		int left = Math.max(0, id - k + 1), right = Math.min(id + k - 1, arr.size() - 1);
		while (right - left + 1 > k) {
			if (Math.abs(arr.get(left) - x) > Math.abs(arr.get(right) - x)) {
				left++;
			}
			else {
				right--;
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			result.add(arr.get(i));
		}
		return result;
	}

	private int findMinId(List<Integer> arr, int x) {
		int id = 0, min = Math.abs(arr.get(0) - x);
		int n = arr.size();
		for (int i = 1; i < n; i++) {
			int v = Math.abs(arr.get(i) - x);
			if (v < min) {
				min = Math.abs(arr.get(i) - x);
				id = i;
			} else if (v == min) {
				continue;
			}
			else {
				break;
			}
		}
		return id;
	}
}
