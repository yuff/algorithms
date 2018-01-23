package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class FindRightInterval {

	public static void main(String[] args) {
		FindRightInterval fr = new FindRightInterval();
		Interval i1 = new Interval(3, 4);
		Interval i2 = new Interval(2, 3);
		Interval i3 = new Interval(1, 2);
		Interval[] intervals = new Interval[] {i1, i2, i3};
		int[] result = fr.findRightInterval(intervals);
		for (int i : result) {
			System.out.print(i + ",");
		}

	}

	public int[] findRightInterval(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return null;
		}
		int len = intervals.length;
		int[] result = new int[len];
		Map<Interval, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			map.put(intervals[i], i);
		}

		List<Map.Entry<Interval, Integer>> list = new ArrayList<>();
		list.addAll(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Interval, Integer>>() {
			@Override
			public int compare(Map.Entry<Interval, Integer> o1, Map.Entry<Interval, Integer> o2) {
				return o1.getKey().start - o2.getKey().start;
			}

		});
		for (int i = 0; i < len; i++) {
			Interval it = list.get(i).getKey();
			int index = list.get(i).getValue();
			boolean found = false;
			for (int j = i + 1; j < len; j++) {
				if (list.get(j).getKey().start >= it.end) {
					result[index] = list.get(j).getValue();
					found = true;
					break;
				}
			}
			if (!found) {
				result[index] = -1;
			}
		}
		return result;
	}
}
