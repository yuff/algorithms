package com.leetcode.newround;

import java.util.*;

public class MyCalendarThree {
	public static void main(String[] args) {
		MyCalendarThree mc = new MyCalendarThree();
		System.out.println(mc.book(47, 50));
		 System.out.println(mc.book(1,10));
		 System.out.println(mc.book(27,36));
		 System.out.println(mc.book(40,47));
		 System.out.println(mc.book(20,27));
		 System.out.println(mc.book(15,23));
		 System.out.println(mc.book(10,18));
		 System.out.println(mc.book(27,36));
		 System.out.println(mc.book(47,50));
		 System.out.println(mc.book(2,7));
		 System.out.println(mc.book(6,13));
	}

	int k = 0;
	Map<Integer, List<int[]>> map = new HashMap<>();

	public MyCalendarThree() {

	}

	public int book(int start, int end) {
		if (k == 0) {
			k++;
			List<int[]> list = new ArrayList<>();
			list.add(new int[] {start, end});
			map.put(k, list);
		}
		else {
			for (int i = k; i >= 1; i--) {
				List<int[]> list = map.get(i);
				List<int[]> iplusone = new ArrayList<>();
				for (int[] book : list) {
					if ((book[0] >= start && book[0] < end) || (book[1] > start && book[1] <= end) ||
					    (book[0] <= start && book[1] >= end)) {
						iplusone.add(new int[] {Math.max(book[0], start), Math.min(book[1], end)});
					}
				}
				if (iplusone.size() > 0) {
					if (map.get(i + 1) != null) {
						map.get(i + 1).addAll(iplusone);
					}
					else {
						k = Math.max(k, i + 1);
						map.put(i + 1, iplusone);
					}
				}
			}
			map.get(1).add(new int[] {start, end});
		}
		return k;
	}
}
