package com.leetcode.newround;

import java.util.*;

public class CouplesHoldingHands {
	public static void main(String[] args) {
		CouplesHoldingHands ch = new CouplesHoldingHands();
		int[] row = new int[] {0, 2, 1, 3};
		System.out.println(ch.minSwapsCouples(row));

		int[] row1 = new int[] {0, 7, 2, 8, 1, 3, 4, 6, 5, 9};
		System.out.println(ch.minSwapsCouples(row1));
	}

	public int minSwapsCouples(int[] row) {
		if (row == null || row.length == 0) {
			return 0;
		}
		Map<Integer, Integer> ids = new HashMap<>();
		for (int i = 0; i < row.length; i++) {
			ids.put(row[i], i);
		}
		int counts = 0;
		for (int i = 0; i < row.length / 2; i++) {
			int num1 = row[2 * i];
			int num2 = row[2 * i + 1];
			int expectCoupleOfNum1 = num1 % 2 == 0 ? num1 + 1 : num1 - 1;
			if (num2 == expectCoupleOfNum1) {
				continue;
			}
			else {
				int idOfExpectCoupleOfNum1 = ids.get(expectCoupleOfNum1);
				swap(row, 2 * i + 1, idOfExpectCoupleOfNum1, ids);
				counts++;
			}
		}
		return counts;
	}

	private void swap(int[] row, int i, int j, Map<Integer, Integer> ids) {
		int tmp = row[i];
		row[i] = row[j];
		row[j] = tmp;
		ids.put(row[i], i);
		ids.put(row[j], j);
	}
}
