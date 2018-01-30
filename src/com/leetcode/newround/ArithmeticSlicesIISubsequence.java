package com.leetcode.newround;

import java.util.*;

public class ArithmeticSlicesIISubsequence {
	public static void main(String[] args) {
		ArithmeticSlicesIISubsequence as = new ArithmeticSlicesIISubsequence();
		System.out.println(as.numberOfArithmeticSlices(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
		System.out.println(as.numberOfArithmeticSlices1(new int[] {1,1,1,1}));
//		System.out.println(as.numberOfArithmeticSlices1(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
		// System.out.println(as.numberOfArithmeticSlices(new int[] {0,2000000000,-294967296}));
	}

	public int numberOfArithmeticSlices(int[] A) {
		if (A == null || A.length < 3) {
			return 0;
		}
		int n = A.length;
		Map<Long, List<Integer>>[] counts = new HashMap[n];
		Map<Long, Integer>[] longerThanThree = new HashMap[n];
		int result = 0;
		counts[0] = new HashMap<>();
		longerThanThree[0] = new HashMap<>();
		for (int i = 1; i < n; i++) {
			counts[i] = new HashMap<>();
			longerThanThree[i] = new HashMap<>();
			for (int j = 0; j < i; j++) {
				long dis = (long) A[i] - A[j];
				List<Integer> list = counts[j].getOrDefault(dis, new ArrayList<>());
				List<Integer> newList = counts[i].getOrDefault(dis, new ArrayList<>());
				int longerThanThreeValue = longerThanThree[i].getOrDefault(dis, 0);
				int pre = longerThanThree[j].getOrDefault(dis, 0) + list.size();
				longerThanThreeValue += pre;
				result += pre;
				newList.add(2);
				counts[i].put(dis, newList);
				longerThanThree[i].put(dis, longerThanThreeValue);
			}
		}
		return result;
	}

	public int numberOfArithmeticSlices1(int[] A) {
		if (A == null || A.length < 3) {
			return 0;
		}
		Map<Integer, List<List<Integer>>> subs = new HashMap<>();
		for (int id = 0; id < A.length; id++) {
			int num = A[id];
			List<List<Integer>> numList = new ArrayList<>();
			for (int key : subs.keySet()) {
				List<List<Integer>> lists = subs.get(key);
				Iterator<List<Integer>> iterator = lists.iterator();
				while (iterator.hasNext()) {
					List<Integer> list = iterator.next();
					if (list.size() < 2 || (long) num - list.get(list.size() - 1) == (long) list.get(1) - list.get(0)) {
						List<Integer> newList = new ArrayList<>(list);
						newList.add(num);
						numList.add(newList);
					}
				}
			}
			List<Integer> list = new ArrayList<>();
			list.add(num);
			numList.add(list);
			subs.put(id, numList);
		}
		int result = 0;
		for (int key : subs.keySet()) {
			List<List<Integer>> lists = subs.get(key);
			for (List<Integer> list : lists) {
				int n = list.size();
				result += (n >= 3 ? 1 : 0);
			}
		}
		return result;
	}
}
