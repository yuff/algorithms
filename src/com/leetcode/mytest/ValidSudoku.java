package com.leetcode.mytest;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			boolean[] filled = new boolean[9];
			for (int j = 0; j < 9; j++) {
				boolean valid = isValid(board, i, filled, j);
				if (!valid) {
					return false;
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			boolean[] filled = new boolean[9];
			for (int j = 0; j < 9; j++) {
				boolean valid = isValid(board, j, filled, i);
				if (!valid) {
					return false;
				}
			}
		}

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				boolean[] filled = new boolean[9];
				for (int i = r * 3 + 0; i < (r + 1) * 3; i++) {
					for (int j = (c * 3); j < (c + 1) * 3; j++) {
						boolean valid = isValid(board, i, filled, j);
						if (!valid) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public boolean isValid(char[][] board, int i, boolean[] filled, int j) {
		if (board[i][j] != '.') {
			if (filled[board[i][j] - '1']) {
				return false;
			}
			else {
				filled[board[i][j] - '1'] = true;
			}
		}
		return true;
	}
}
