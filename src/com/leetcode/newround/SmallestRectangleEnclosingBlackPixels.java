package com.leetcode.newround;

import java.util.LinkedList;

public class SmallestRectangleEnclosingBlackPixels {

	public int smallestEnclosing(char[][] image, int x, int y) {
		if (image == null || x < 0 || y < 0 || image.length <= x || image[0].length <= y) {
			return 0;
		}
		int left = x, right = x, bottom = y, top = y;
		int m = image.length, n = image[0].length;
		boolean[][] visit = new boolean[m][n];
		LinkedList<int[]> stack = new LinkedList<>();
		stack.add(new int[] {x, y});
		while (!stack.isEmpty()) {
			int[] p = stack.pop();
			visit[p[0]][p[1]] = true;
			if (p[0] < left) {
				left = p[0];
			}
			if (p[0] > right) {
				right = p[0];
			}
			if (p[1] < top) {
				top = p[1];
			}
			if (p[1] > bottom) {
				bottom = p[1];
			}
			if (p[0] > 0 && image[p[0] - 1][p[1]] == '1' && !visit[p[0] - 1][p[1]]) {
				stack.push(new int[] {p[0] - 1, p[1]});
			}
			if (p[0] < m - 1 && image[p[0] + 1][p[1]] == '1' && !visit[p[0] + 1][p[1]]) {
				stack.push(new int[] {p[0] + 1, p[1]});
			}
			if (p[1] > 0 && image[p[0]][p[1] - 1] == '1' && !visit[p[0]][p[1] - 1]) {
				stack.push(new int[] {p[0], p[1] - 1});
			}
			if (p[1] < n - 1 && image[p[0]][p[1] + 1] == '1' && !visit[p[0]][p[1] + 1]) {
				stack.push(new int[] {p[0], p[1] + 1});
			}
		}
		return (bottom - top + 1) * (right - left + 1);
	}
}
