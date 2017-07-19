package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangement {
	public static void main(String[] args) {
		BeautifulArrangement ba = new BeautifulArrangement();
		System.out.println(ba.countArrangement(10));
	}
	public int countArrangement(int N) {
		List<List<Integer>> allList = premutation(N);
		return allList.size();
//		int result = 0;
//		for (List<Integer> list : allList) {
//			if (isBeautiful(list)) {
//				result++;
//			}
//		}
//		return result;
	}

	private boolean isBeautiful(List<Integer> list) {
		int length = list.size();
		boolean result = true;
		for (int i = 0; i < length; i++) {
			int pos = i + 1;
			int value = list.get(i);
			if (pos % value != 0 && value % pos != 0) {
				result = false;
			}
		}
		return result;
	}

	private List<List<Integer>> premutation(int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		boolean[] isVisited = new boolean[n];
		premutation(n, result, tmp, 0, isVisited);
		return result;
	}

	private void premutation(int n, List<List<Integer>> result, List<Integer> tmp, int depth, boolean[] isVisited) {
		if (depth == n) {
			result.add(new ArrayList<>(tmp));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!isVisited[i]) {
				tmp.add(i + 1);
				int pos = tmp.size();
				int value = i + 1;
				if( pos % value == 0 || value % pos == 0) {
					isVisited[i] = true;
					premutation(n, result, tmp, depth + 1, isVisited);
					isVisited[i] = false;
				}
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
