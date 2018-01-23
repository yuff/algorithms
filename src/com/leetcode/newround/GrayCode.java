package com.leetcode.newround;

import java.util.*;

public class GrayCode {
	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		System.out.println(gc.grayCode(3));
	}
	public List<Integer> grayCode(int n) {
		if (n == 0) {
			return new ArrayList<>();
		}
		int total = (int) Math.pow(2, n);
		boolean[] visited = new boolean[total];
		List<Integer> result = new ArrayList<>();
		result.add(0);
		visited[0] = true;
		fill(result, visited, 1, n);
		return result;
	}

	private boolean fill(List<Integer> result, boolean[] visited, int start, int n) {
		if (start == visited.length) {
			return true;
		}
		int[] next = new int[2];
		next[0] = 0;
		while (next[0] < n) {
			findNext(result.get(result.size() - 1), visited, next, n);
			result.add(next[1]);
			visited[next[1]] = true;
			boolean res = fill(result, visited, start + 1, n);
			if (res) {
				return true;
			}
			else {
				visited[next[1]] = false;
				result.remove(result.size() - 1);
			}
		}
		return false;
	}

	private void findNext(int lastVal, boolean[] visited, int[] next, int n) {
		while (next[0] < n) {
			int val = 1 << next[0];
			int tmp = 0;
			if ( (val & lastVal) == val) {
				tmp = lastVal - val;
			} else {
				tmp = lastVal + val;
			}
			next[0]++;
			if (tmp >= 0 && !visited[tmp]) {
				next[1] = tmp;
				return;
			}
		}
	}
}
