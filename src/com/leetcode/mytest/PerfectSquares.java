package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
	public static void main(String[] args) {
		PerfectSquares ps = new PerfectSquares();
		System.out.println(ps.numSquares(12));
		System.out.println(ps.numSquares(13));
	}

	public int numSquares(int n) {
		if (n < 4) {
			return n;
		}
		int count = (int) Math.sqrt(n);
		if (count * count == n) {
			return 1;
		}
		int[] nums = new int[n + 1];
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= (count + 1); i++) {
			if (i * i < n) {
				list.add(i * i);
				nums[i * i] = 1;
			}
			else {
				break;
			}
		}
		nums[0] = 0;
		int i = 1;
		int size = list.size();
		while (i < 4) {
			nums[i] = i;
			i++;
		}
		for (i = 4; i <= n; i++) {
			if (nums[i] == 0) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < size; j++) {
					int value = list.get(j);
					if (value <= i) {
						int tmp = nums[value] + nums[i - value];
						if (tmp < min) {
							min = tmp;
						}
					}
				}
				nums[i] = min;
			}
		}
		return nums[n];
	}
}
