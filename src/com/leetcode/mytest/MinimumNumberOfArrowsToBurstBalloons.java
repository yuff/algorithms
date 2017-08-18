package com.leetcode.mytest;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

	public static void main(String[] args) {
		MinimumNumberOfArrowsToBurstBalloons mo = new MinimumNumberOfArrowsToBurstBalloons();
		int[][] points = new int[10][2];
		points[0] = new int[] {3, 9};
		points[1] = new int[] {7, 12};
		points[2] = new int[] {3, 8};
		points[3] = new int[] {6, 8};
		points[4] = new int[] {9, 10};
		points[5] = new int[] {2, 9};
		points[6] = new int[] {0, 9};
		points[7] = new int[] {3, 9};
		points[8] = new int[] {0, 6};
		points[9] = new int[] {2, 8};
		System.out.println(mo.findMinArrowShots(points));
	}

	public int findMinArrowShots(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {					
					return o1[0] - o2[0];
				}
			}
		});
		int n = points.length;
		int count = 0;
		for (int i = 0; i < n;) {
			count++;
			int end = points[i][1];
			int j = i + 1;
			for (; j < n; j++) {
				if (points[j][0] > end) {
					break;
				} else {
					int tmp = points[j][1];
					if (tmp < end) {
						end = tmp;
					}
				}
			}
			i = j;
		}
		return count;
	}
}
