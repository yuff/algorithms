package com.leetcode.mytest;

import java.util.*;

public class UglyNumberII {
	public static void main(String[] args) {
		UglyNumberII un = new UglyNumberII();
		System.out.println(un.nthUglyNumber(1600));
	}
	public int nthUglyNumber(int n) {
		if (n < 1) {
			return -1;
		}
		if (n == 1) {
			return 1;
		}
		int[] arr = new int[n];
		List<Integer> tmp = new ArrayList<>();
		arr[0] = 1;
		List<List<Integer>> list = new ArrayList<>();
		list.add(generateList(1));
		for (int i = 1; i < n; i++) {
			int num = findSmallest(list);
			arr[i] = num;
			List<Integer> t = generateList(num);
			if (t.size() > 0) {				
				list.add(t);
			}
			tmp.add(num);
		}
		System.out.println(tmp);
		return arr[n - 1];
	}

	private int findSmallest(List<List<Integer>> list) {
		List<Integer> ids = new ArrayList<>();
		int n = list.size();
		int smallest = list.get(0).get(0);
		ids.add(0);
		for(int i = 1; i < n; i++) {
			int cur = list.get(i).get(0);
			if (cur < smallest) {
				ids.clear();
				ids.add(i);
				smallest = cur;
			} else if (cur == smallest) {
				ids.add(i);
			} else {
				if (list.get(i).size() == 3) {
					break;
				}
			}
		}
		for(int i = ids.size() - 1; i >= 0; i--) {
			int id = ids.get(i);
			list.get(id).remove(0);
			if (list.get(id).size() == 0) {
				list.remove(id);
			}
		}
		return smallest;
	}

	private List<Integer> generateList(int i) {
		List<Integer> result = new ArrayList<>();
		if (Integer.MAX_VALUE / 5 >= i) {			
			result.add(i * 2);
			result.add(i * 3);
			result.add(i * 5);
		} else 	if (Integer.MAX_VALUE / 3 >= i) {			
			result.add(i * 2);
			result.add(i * 3);
		} else if (Integer.MAX_VALUE >> 1 >= i) {			
			result.add(i * 2);
		}
		return result;
	}
}
