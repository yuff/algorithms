package com.java8;

import java.util.*;

import com.java8.util.CommonUtil;

public class LargestDistance {

	public static void main(String[] args) {
		LargestDistance ld = new LargestDistance();
		List<List<Integer>> list = new ArrayList<>();
		list.add(CommonUtil.convertToList(new int[] {1, 2, 3, 4, 5, 6, 12}));
		list.add(CommonUtil.convertToList(new int[] {2, 3, 6, 7, 9}));
//		list.add(CommonUtil.convertToList(new int[] {-3, 3, 5, 6, 7, 8, 11}));
//		list.add(CommonUtil.convertToList(new int[] {4, 5, 6, 7, 8}));
		System.out.println(ld.largestDistance(list));
	}

	public int largestDistance(List<List<Integer>> list) {
		if (list == null || list.isEmpty() || list.size() < 2) {
			return 0;
		}
		boolean isDiff = false;
		List<Integer> l1 = list.get(0);
		int max = l1.get(l1.size() - 1), min = l1.get(0), preMax = Integer.MIN_VALUE, preMin = Integer.MAX_VALUE;
		for (int i = 1; i < list.size(); i++) {
			List<Integer> l = list.get(i);
			int curMax = l.get(l.size() - 1), curMin = l.get(0);
			preMax = Math.max(preMax, Math.min(max, curMax));
			max = Math.max(max, curMax);
			preMin = Math.min(preMin, Math.max(min, curMin));
			min = Math.min(min, curMin);
			isDiff = (max == curMax && min != curMin) || (max != curMax && min == curMin) ||
			         (max != curMax && min != curMin && isDiff);
		}
		if (isDiff) {
			return max - min;
		}
		else {
			return Math.max(max - preMin, preMax - min);
		}
	}
}
