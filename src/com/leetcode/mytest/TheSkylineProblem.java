package com.leetcode.mytest;

import java.util.*;

public class TheSkylineProblem {
	public static void main(String[] args) {
		TheSkylineProblem ts = new TheSkylineProblem();
		// int[][] buildings = new int[5][3];
		// buildings[0] = new int[] {2, 9, 10};
		// buildings[1] = new int[] {3, 7, 15};
		// buildings[2] = new int[] {5, 12, 12};
		// buildings[3] = new int[] {15, 20, 10};
		// buildings[4] = new int[] {19, 28, 8};

		int[][] buildings = new int[3][3];
		buildings[0] = new int[] {1, 2, 1};
		buildings[1] = new int[] {1, 2, 2};
		buildings[2] = new int[] {1, 2, 10};
		List<int[]> result = ts.getSkyline(buildings);
		for (int[] r : result) {
			System.out.print("[" + r[0] + "," + r[1] + "],");
		}
	}

	public List<int[]> getSkyline(int[][] buildings) {
		if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
			return new ArrayList<>();
		}
		List<Point> points = new ArrayList<>();
		for (int[] build : buildings) {
			Point left = new Point(build[0], build[2], true, build[1]);
			Point right = new Point(build[1], build[2], false, left);
			points.add(left);
			points.add(right);
		}
		Collections.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if (p1.x == p2.x) {
					int y1 = p1.isLeft? -p1.y : p1.y;
					int y2 = p2.isLeft? -p2.y : p2.y;
					return y1 - y2;
				}
				else {
					return p1.x - p2.x;
				}
			}
		});
		List<int[]> result = new ArrayList<>();
		result.add(new int[] {points.get(0).x, points.get(0).y});
		List<Point> leftList = new ArrayList<>();
		leftList.add(points.get(0));
		int curMaxHeight = points.get(0).y;
		int n = points.size();
		for (int i = 1; i < n; i++) {
			Point cur = points.get(i);
			if (!cur.isLeft) { 
				leftList.remove(cur.left);
				if (cur.y == curMaxHeight) {
					leftList.remove(cur.left);
					curMaxHeight = findCurMaxHeight(leftList);
					if (curMaxHeight < cur.y) {
						result.add(new int[] {cur.x, curMaxHeight});
					}
				}
			}
			else {
				int y = cur.y;
				leftList.add(cur);
				if (y > curMaxHeight) {
					curMaxHeight = y;
					result.add(new int[] {cur.x, cur.y});
				}
			}
		}
		return result;
	}

	private int findCurMaxHeight(List<Point> list) {
		if (list.size() == 0) {
			return 0;
		}
		int result = 0;
		for (Point p : list) {
			result = Math.max(p.y, result);
		}
		return result;
	}
}

class Point {
	Point(int x, int y, boolean isLeft, int right) {
		this.x = x;
		this.y = y;
		this.isLeft = isLeft;
		this.right = right;
	}

	Point(int x, int y, boolean isLeft, Point left) {
		this.x = x;
		this.y = y;
		this.isLeft = isLeft;
		this.left = left;
	}

	int x;
	int y;
	boolean isLeft;
	Point left;
	int right;
}
