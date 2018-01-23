package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumSwap {
	public static void main(String[] args) {
		MaximumSwap ms = new MaximumSwap();
		System.out.println(ms.maximumSwap(19931));
		System.out.println(ms.maximumSwap(99901));
		System.out.println(ms.maximumSwap(9739));
		System.out.println(ms.maximumSwap(99379));
		System.out.println(ms.maximumSwap(2221));
	}

	public int maximumSwap(int num) {
		List<Integer> list = new ArrayList<>();
		List<int[]> index = new ArrayList<>();
		while (num > 0) {
			list.add(num % 10);
			num /= 10;
			int[] t = new int[2];
			t[0] = list.size() - 1;
			t[1] = list.get(t[0]);
			index.add(t);
		}
		Collections.sort(index, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o2[1] - o1[1];
			}
		});
		int n = list.size() - 1;
		for (int i = 0; i < index.size();) {
			int[] id = index.get(i);
			if (id[0] > n) {
				i++;
			}
			else if (id[0] == n) {
				n--;
				i++;
				if (n < 0) {
					break;
				}
			}
			else if (id[1] == list.get(n)) {
				n--;
				if (n < 0) {
					break;
				}
			}
			else {
				int value = list.get(n);
				list.set(n, id[1]);
				list.set(id[0], value);
				break;
			}

		}
		int result = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			result = (result * 10) + list.get(i);
		}
		return result;
	}
}
