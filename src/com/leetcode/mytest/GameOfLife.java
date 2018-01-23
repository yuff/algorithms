package com.leetcode.mytest;

public class GameOfLife {
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		int m = board.length;
		int n = board[0].length;
		int[][] pre = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				setNext(board, pre, i, j);
			}
		}
	}

	private void setNext(int[][] board, int[][] pre, int i, int j) {
		int m = board.length;
		int n = board[0].length;
		int live = 0;
		if (m == 1 || n == 1) {
			board[i][j] = 0;
			return;
		}
		pre[i][j] = board[i][j];
		if (i == 0) {
			if (j == 0) {
				live += (board[i + 1][j] + board[i][j + 1] + board[i + 1][j + 1]);
			}
			else if (j == n - 1) {
				live += (pre[i][j - 1] + board[i + 1][j] + board[i + 1][j - 1]);
			}
			else {
				live += (pre[i][j - 1] + board[i][j + 1] + board[i + 1][j - 1] + board[i + 1][j] + board[i + 1][j + 1]);
			}
		}
		else if (i < m - 1){
			if (j == 0) {
				live += (pre[i - 1][j] + pre[i - 1][j + 1] + board[i][j + 1] + board[i + 1][j] + board[i + 1][j + 1]);
			}
			else if (j == n - 1) {
				live += (pre[i][j - 1] + pre[i - 1][j - 1] + pre[i - 1][j] + board[i + 1][j] + board[i + 1][j - 1]);
			}
			else {
				live += (pre[i - 1][j - 1] + pre[i - 1][j] + pre[i - 1][j + 1] + pre[i][j - 1] + board[i][j + 1] +
				         board[i + 1][j - 1] + board[i + 1][j] + board[i + 1][j + 1]);
			}
		} else {
			if (j == 0) {
				live += (pre[i- 1][j] + board[i][j + 1] + pre[i - 1][j + 1]);
			}
			else if (j == n - 1) {
				live += (pre[i][j - 1] + pre[i - 1][j] + pre[i - 1][j - 1]);
			}
			else {
				live += (pre[i][j - 1] + board[i][j + 1] + pre[i - 1][j - 1] + pre[i - 1][j] + pre[i + 1][j + 1]);
			}
		}
		if (board[i][j] == 0) {
			if (live == 3) {
				board[i][j] = 1;
			}
		} else {
			if (live < 2) {
				board[i][j] = 0;
			} else if (live > 3) {
				board[i][j] = 0;
			}
		}
	}
}
