package com.leetcode.mytest;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		ContainerWithMostWater cwm = new ContainerWithMostWater();
		int[] nums = new int[15000];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		System.out.println(cwm.maxArea(nums));
		System.out.println(cwm.maxArea(new int[] {2, 4, 5, 3, 1, 6, 4, 7, 8, 2, 9}));
		System.out.println(cwm.maxArea(new int[] {1, 1}));
	}

	public int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int n = height.length;
		int result = 0;
		int s = 0, e = n - 1;
		while (s < e) {
			int tmp = Math.min(height[s], height[e]) * (e - s);
			if (tmp > result) {
				result = tmp;
			}
			if (height[s] < height[e]) {
				s++;
			}
			else {
				e--;
			}
		}
		return result;
	}

	public int maxArea2(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int n = height.length;
		int[] c = new int[n];
		int result = 0;
		for (int i = 1; i < n; i++) {
			int max = 0;
			for (int j = 0; j < (n - i); j++) {
				int k = j + i;
				int tmp = Math.min(height[j], height[k]);
				if (tmp > max) {
					max = tmp;
				}
			}
			c[i] = max * i;
			if (c[i] > result) {
				result = c[i];
			}
		}
		return result;
	}

	public int maxArea1(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int n = height.length;
		int[] c = new int[n];
		int[] r = new int[n];
		c[0] = 0;
		r[0] = -1;
		c[1] = Math.min(height[0], height[1]);
		r[1] = 0;
		int result = c[1];
		for (int i = 2; i < n; i++) {
			int max = 0;
			int id = -1;
			for (int k = 0; k < i; k++) {
				if (id < 0 || height[k] > height[id]) {
					int tmp = Math.min(height[i], height[k]) * (i - k);
					if (tmp > max) {
						max = tmp;
						id = k;
					}
				}
			}
			c[i] = max;
			r[i] = id;
			if (c[i] > result) {
				result = c[i];
			}
		}
		return result;
	}
}
