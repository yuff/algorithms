package com.leetcode.newround;

import java.util.*;

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class MaxPointsOnALine {
	public static void main(String[] args) {
		MaxPointsOnALine mp = new MaxPointsOnALine();
		System.out.println(mp.maxPoints(new Point[] {new Point(0, 0), new Point(94911151, 94911150),
		                                             new Point(94911152, 94911151)}));
	}

	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}

		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if (p1.x == p2.x) {
					return p1.y - p2.y;
				}
				else {
					return p1.x - p2.x;
				}
			}
		});
		int n = points.length, max = 1, i = 0;
		Map<String, Integer> map = new HashMap<>();
		while (i < n) {
			Point p1 = points[i];
			int j = i + 1, same = 1;
			while (j < n) {
				Point p2 = points[j];
				if (p2.x == p1.x && p2.y == p1.y) {
					same++;
					j++;
				}
				else {
					String k = "NA";
					if (p2.x != p1.x) {
						int y = p2.y - p1.y;
						int x = p2.x - p1.x;
						if (y == 0) {
							k = "0";
						}
						else {
							int gcd = gcd(x, y);
							y /= gcd;
							x /= gcd;
							k = x + "," + y;
						}
					}
					int count = map.getOrDefault(k, same);
					map.put(k, count + 1);
					max = Math.max(max, count + 1);
					j++;
				}
			}
			max = Math.max(max, same);
			i += same;
			map.clear();
		}
		return max;
	}

	private int gcd(int x, int y) {
		if (y == 0) return x;
		return gcd(y, x % y);
	}
}
