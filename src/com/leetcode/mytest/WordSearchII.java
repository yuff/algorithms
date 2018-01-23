package com.leetcode.mytest;

import java.util.*;

public class WordSearchII {
	public static void main(String[] args) {
		WordSearchII ws = new WordSearchII();
		char[][] board = new char[1][1];
		board[0] = new char[] {'a'};
		String[] words = new String[] {"a", "a"};
		System.out.println(ws.findWords(board, words));
	}

	public List<String> findWords(char[][] board, String[] words) {
		if (board == null || board.length == 0 || board[0].length == 0 || words == null) {
			return new ArrayList<>();
		}
		Set<String> result = new HashSet<>();
		int m = board.length, n = board[0].length;
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
		for (String word : words) {
			if (exist(board, word, map)) {
				result.add(word);
			}
		}
		return new ArrayList<>(result);
	}

	private boolean exist(char[][] board, String word, Map<Character, List<int[]>> map) {
		int m = board.length, n = board[0].length;
		if (word.length() > m * n) {
			return false;
		}
		boolean[][] visit = new boolean[m][n];
		char[] arr = word.toCharArray();
		List<int[]> ids = map.get(arr[0]);
		if (ids == null) {
			return false;
		}
		for (int[] id : ids) {
			int i = id[0], j = id[1];
			if (!visit[i][j]) {
				List<Character> neighbors = getNeighbors(m, n, i, j);
				boolean r = find(board, i, j, visit, neighbors, arr, 0);
				if (r) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean find(char[][] board, int i, int j, boolean[][] visit, List<Character> neighbors, char[] arr,
	                     int id) {
		visit[i][j] = true;
		if (arr.length - 1 == id) {
			return true;
		}
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
		else if (i > 0 && i < m - 1) {
			neighbors.add('D');
			neighbors.add('U');
		}
		if (j == 0 && j != n - 1) {
			neighbors.add('R');
		}
		else if (j == n - 1 && j != 0) {
			neighbors.add('L');
		}
		else if (j > 0 && j < n - 1) {
			neighbors.add('L');
			neighbors.add('R');
		}
		return neighbors;
	}
}
