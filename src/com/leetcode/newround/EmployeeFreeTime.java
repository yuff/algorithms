package com.leetcode.newround;

import java.util.*;

public class EmployeeFreeTime {
	public static void main(String[] args) {
		EmployeeFreeTime eft = new EmployeeFreeTime();
		List<List<Interval>> schedule = new ArrayList<>();
		List<Interval> one = new ArrayList<>();
		one.add(new Interval(1, 2));
		one.add(new Interval(5, 6));
		schedule.add(one);
		List<Interval> two = new ArrayList<>();
		two.add(new Interval(1, 3));
		schedule.add(two);

		List<Interval> three = new ArrayList<>();
		two.add(new Interval(4, 10));
		schedule.add(three);
		List<Interval> result = eft.employeeFreeTime(schedule);
		for (Interval i : result) {
			System.out.println(i.start + "," + i.end);
		}
	}

	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		if (schedule == null || schedule.isEmpty()) {
			return new ArrayList<>();
		}
		List<List<Interval>> free = new ArrayList<>();
		for (List<Interval> list : schedule) {
			free.add(convertToFree(list));
		}
		List<Interval> first = free.get(0);
		for (int i = 1; i < free.size(); i++) {
			List<Interval> second = free.get(i);
			first = findCommon(first, second);
		}
		if (first.get(0).start < 0) {
			first.remove(0);
		}
		if (first.get(first.size() - 1).end == Integer.MAX_VALUE) {
			first.remove(first.size() - 1);
		}
		return first;
	}

	private List<Interval> findCommon(List<Interval> first, List<Interval> second) {
		List<Interval> result = new ArrayList<>();
		int m = first.size(), n = second.size(), i = 0, j = 0;
		while (i < m && j < n) {
			Interval in1 = first.get(i), in2 = second.get(j);
			if (in1.start >= in2.end) {
				j++;
			}
			else if (in2.start >= in1.end) {
				i++;
			}
			else {
				Interval common = new Interval();
				common.start = Math.max(in1.start, in2.start);
				common.end = Math.min(in1.end, in2.end);
				result.add(common);
				if (in1.end > in2.end) {
					j++;
				}
				else if (in1.end < in2.end) {
					i++;
				}
				else {
					i++;
					j++;
				}
			}
		}
		return result;
	}

	private List<Interval> convertToFree(List<Interval> list) {
		List<Interval> result = new ArrayList<>();
		int start = Integer.MIN_VALUE;
		for (Interval in : list) {
			if (start != in.start) {
				Interval free = new Interval();
				free.start = start;
				free.end = in.start;
				result.add(free);
			}
			start = in.end;
		}
		Interval free = new Interval();
		free.start = start;
		free.end = Integer.MAX_VALUE;
		result.add(free);
		return result;
	}
}

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
