package com.leetcode.mytest;

import java.util.*;

public class NQueens {
	public static void main(String[] args) {
		NQueens nq = new NQueens();
		System.out.println(nq.solveNQueens(4));
		System.out.println(nq.solveNQueens(10).size());
		System.out.println(nq.solveNQueens(10));
	}
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] pos = new int[n];
        char[] arr = new char[n];
        Arrays.fill(arr, '.');
        solveNQueens(result, n, pos, 0, arr);
        return result;
    }

	private void solveNQueens(List<List<String>> result, int n, int[] pos, int start,  char[] arr) {
		if (start == n) {
			result.add(generateResultStr(pos, arr));
			return;
		}
		for(int i = 0; i < n; i++) {
			if (canPut(pos, start, i)) {
				pos[start] = i;
				solveNQueens(result, n, pos, start + 1, arr);
			}
		}
	}

	private List<String> generateResultStr(int[] pos, char[] arr) {
		List<String> result = new ArrayList<>();
		for(int p: pos) {
			arr[p] = 'Q';
			result.add(new String(arr));
			arr[p] = '.';
		}
		return result;
	}

	private boolean canPut(int[] pos, int id, int value) {
		for(int i = 0; i < id; i++) {
			if (pos[i] == value || Math.abs(id - i) == Math.abs(value - pos[i])) {
				return false;
			}
		}
		return true;
	}
}
