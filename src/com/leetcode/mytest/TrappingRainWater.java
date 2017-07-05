package com.leetcode.mytest;

public class TrappingRainWater {
	public static void main(String[] args) {
		int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int[] array1 = {4,2,3};
		TrappingRainWater trw = new TrappingRainWater();
		System.out.println(trw.trap(array));
		System.out.println(trw.trap(array1));
	}

	public int trap(int[] height) {
		int len = height.length;
		int result = 0;
		for (int i = 0; i < len;) {
			if (height[i] == 0) {
				i++;
			}
			else {
				int value = height[i];
				int end = i + 1;
				int lessMax = 0;
				int lessMaxIndex = -1;
				while (end < len && height[end] < value) {
					int tmp = height[end];
					if (tmp > lessMax) {
						lessMax = tmp;
						lessMaxIndex = end;
					}
					end++;
				}
				if (end >= len) {
					if (lessMax > 0) {
						result += calculateTrap(i, lessMaxIndex, height);
						i = lessMaxIndex;
					} else {						
						i++;
					}
				}
				else if (height[end] >= value) {
					result += calculateTrap(i, end, height);
					i = end;
				}
			}
		}
		return result;
	}

	private int calculateTrap(int start, int end, int[] height) {
		int width = end - start - 1;
		if (width <=0) {
			return 0;
		}
		int result = width * Math.min(height[start], height[end]);
		for (int i = start + 1; i < end; i++) {
			result -= height[i];
		}
		return result;
	}
}
