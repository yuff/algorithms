package com.leetcode.mytest;

import java.util.*;

public class WordSearch {
	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char[][] board = new char[3][4];
		board[0] = new char[] {'A', 'B', 'C', 'E'};
		board[1] = new char[] {'S', 'F', 'C', 'S'};
		board[2] = new char[] {'A', 'D', 'E', 'E'};
//		System.out.println(ws.exist(board, "MBCCED"));
//		System.out.println(ws.exist(board, "SEE"));
//		System.out.println(ws.exist(board, "ABCB"));
//		System.out.println(ws.exist(board, "ASFCE"));
		
		char[][] board1 = new char[2][1];
		board1[0] = new char[] {'a'};
		board1[1] = new char[] {'a'};
		System.out.println(ws.exist(board1, "aa"));
	}

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
			return false;
		}
		int m = board.length, n = board[0].length;
		if (word.length() > m * n) {
			return false;
		}
		Map<Character, List<int[]>> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char c = board[i][j];
				if (map.get(c) == null) {
					map.put(c, new ArrayList<>());
				}
				map.get(c).add(new int[] {i, j});
			}
		}
		char[] arr = word.toCharArray();
		boolean[][] visit = new boolean[m][n];
		List<int[]> ids = map.get(arr[0]);
		if (ids == null) {
			return false;
		}
		for (int[] id : ids) {
			int i = id[0], j = id[1];
			List<Character> neighbors = getNeighbors(m, n, i, j);
			boolean r = find(board, i, j, visit, neighbors, arr, 0);
			if (r) {
				return true;
			}
		}
		return false;
	}

	private boolean find(char[][] board, int i, int j, boolean[][] visit, List<Character> neighbors, char[] arr,
	                     int id) {
		if (arr.length - 1 == id) {
			return true;
		}
		visit[i][j] = true;
		for (char neighbor : neighbors) {
			int[] ids = getIds(i, j, neighbor);
			List<Character> newNewghbors = getNeighbors(board.length, board[0].length, ids[0], ids[1]);
			if (!visit[ids[0]][ids[1]] && arr[id + 1] == board[ids[0]][ids[1]]) {
				boolean r = find(board, ids[0], ids[1], visit, newNewghbors, arr, id + 1);
				if (r) {
					return true;
				}
			}
		}
		visit[i][j] = false;
		return false;
	}

	private int[] getIds(int i, int j, char neighbor) {
		int[] result = new int[2];
		switch (neighbor) {
			case 'L':
				result[0] = i;
				result[1] = j - 1;
				break;
			case 'R':
				result[0] = i;
				result[1] = j + 1;
				break;
			case 'U':
				result[0] = i - 1;
				result[1] = j;
				break;
			case 'D':
				result[0] = i + 1;
				result[1] = j;
				break;
		}
		return result;
	}

	private List<Character> getNeighbors(int m, int n, int i, int j) {
		List<Character> neighbors = new ArrayList<>();
		if (i == 0 && i != m - 1) {
			neighbors.add('D');
		}
		else if (i == m - 1 && i != 0) {
			neighbors.add('U');
		}
		else if (i > 0 && i < m - 1){
			neighbors.add('D');
			neighbors.add('U');
		}
		if (j == 0 && j != n - 1) {
			neighbors.add('R');
		}
		else if (j == n - 1 && j != 0) {
			neighbors.add('L');
		}
		else if (j > 0 && j < n - 1){
			neighbors.add('L');
			neighbors.add('R');
		}
		return neighbors;
	}
}
