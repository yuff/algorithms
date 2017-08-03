package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {

	public static void main(String[] args) {
		NQueensII nq = new NQueensII();
		System.out.println(nq.totalQueen(10));
	}
	public int totalQueen(int n) {
		if (n == 0) {
			return 0;
		}
		List<List<Integer>> result = new ArrayList<>();
		boolean[] isVisit = new boolean[n];
		List<Integer> tmp = new ArrayList<>();
		int sum = play(result,0, tmp, n, isVisit);
		System.out.println(result.size());
		System.out.println(result);
		return sum;
	}

	private int play(List<List<Integer>> result, int sum, List<Integer> tmp, int n, boolean[] isVisit) {
		if (tmp.size() == n) {
			sum =  sum + 1;
			List<Integer> r = new ArrayList<>(tmp);
			result.add(r);
		}
		for(int i = 0; i < n; i++) {
			if (!isVisit[i]) {
				if (canPut(tmp, i)) {
					isVisit[i] = true;
					tmp.add(i);
					sum = play(result, sum, tmp, n, isVisit);
					isVisit[i] = false;
					tmp.remove(tmp.size() - 1);
				}
			}
		}
		return sum;
	}

	private boolean canPut(List<Integer> tmp, int value) {
		boolean result = true;
		int index = tmp.size();
		for(int i = 0; i < index; i++) {
			if (Math.abs(index - i) == Math.abs(tmp.get(i) - value)){
				return false;
			}
		}
		return result;
	}
}
