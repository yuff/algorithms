package com.leetcode.newround;

import java.util.*;

public class SlidingPuzzle2 {
	public static void main(String[] args) {
		SlidingPuzzle2 sp = new SlidingPuzzle2();
		 int[][] board = {{4, 3, 5}, {2, 1, 0}};
		int[][] board1 = {{4, 1, 2}, {5, 0, 3}};
		 System.out.println(sp.slidingPuzzle(board));
		System.out.println(sp.slidingPuzzle(board1));
	}

	public int slidingPuzzle(int[][] board) {
		int result = -1;
		String finalStr = "123450";
		String str = buildStr(board);
		if (finalStr.equals(str)) {
			return 0;
		}
		Map<String, Integer> steps = new HashMap<>();
		steps.put(str, 0);
		LinkedList<String> stack = new LinkedList<>();
		LinkedList<String> next = new LinkedList<>();
		stack.push(str);
		boolean found = false;
		while (!stack.isEmpty()) {
			String top = stack.pop();
			int curStep = steps.get(top);
			List<String> strs = moveOneStep(top);
			for (String s : strs) {
				if (finalStr.equals(s)) {
					result = curStep + 1;
					found = true;
					break;
				}
				else {
					if (!steps.containsKey(s)) {
						steps.put(s, curStep + 1);
						next.push(s);
					}
				}
			}
			if (found) {
				break;
			}
			if (stack.isEmpty()) {
				stack.addAll(next);
				next.clear();
			}
		}
		return result;
	}

	private List<String> moveOneStep(String str) {
		List<String> result = new ArrayList<>();
		int id = str.indexOf("0");
		if ((id + 1) % 3 != 0) {
			result.add(switchPos(str, id, id + 1));
		}
		if (id % 3 != 0) {
			result.add(switchPos(str, id, id - 1));
		}
		if (id + 3 < str.length()) {
			result.add(switchPos(str, id, id + 3));
		}
		if (id - 3 >= 0) {
			result.add(switchPos(str, id, id - 3));
		}
		return result;
	}

	private String switchPos(String str, int i, int j) {
		char[] arr = str.toCharArray();
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		return new String(arr);
	}

	private String buildStr(int[][] board) {
		int m = board.length, n = board[0].length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(board[i][j]);
			}
		}
		return sb.toString();
	}
}
