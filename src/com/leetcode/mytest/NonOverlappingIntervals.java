package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NonOverlappingIntervals {
	public static void main(String[] args) {
		NonOverlappingIntervals noi = new NonOverlappingIntervals();
		Interval[] intervals =
		                new Interval[] {new Interval(0, 1), new Interval(1, 2), new Interval(2, 4), new Interval(3, 5),
		                                new Interval(4, 6), new Interval(6, 7)};
		System.out.println(noi.eraseOverlapIntervals(intervals));
		System.out.println(noi.eraseOverlapIntervalsGreedy(intervals));
	}

	public int eraseOverlapIntervalsGreedy(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.end == o2.end) {
					return o1.start - o2.start;
				}
				else {
					return o1.end - o2.end;
				}
			}

		});
		int n = intervals.length;
		int id = 0;
		int count = 0;
		while (id < n) {
			count++;
			int next = findNextIndex(intervals, id);
			id = next;
		}
		return n - count;
	}

	private int findNextIndex(Interval[] intervals, int index) {
		Interval it = intervals[index];
		int n = intervals.length;
		int result = n;
		for (int i = index + 1; i < n; i++) {
			if (intervals[i].start >= it.end) {
				result = i;
				break;
			}
		}
		return result;
	}

	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start == o2.start) {
					return o1.end - o2.end;
				}
				else {
					return o1.start - o2.start;
				}
			}

		});
		int count = 0;
		List<Interval> list = new ArrayList<>();
		int len = intervals.length;
		int index = 0;
		while (index < len) {
			Interval it = intervals[index];
			list.add(it);
			int next = findNextDiffStart(intervals, index);
			count += (next - index - 1);
			index = next;
		}

		int n = list.size();
		int[] lenArr = new int[n];
		List<List<Integer>> confilcts = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			confilcts.add(findConfilcts(list, i));
		}
		lenArr[n - 1] = 1;
		int maxLen = 1;
		for (int i = n - 2; i >= 0; i--) {
			int tmp = 0;
			int id = findNextIndex(list, i);
			if (id >= 0 && id < n) {
				tmp = lenArr[id];
				List<Integer> confilct = confilcts.get(id);
				for (int c : confilct) {
					if (lenArr[c] > tmp) {
						tmp = lenArr[c];
					}
				}
			}
			lenArr[i] = tmp + 1;
			if (lenArr[i] > maxLen) {
				maxLen = lenArr[i];
			}
		}
		return count + n - maxLen;
	}

	private int findNextIndex(List<Interval> list, int i) {
		int n = list.size();
		Interval it = list.get(i);
		for (int j = i + 1; j < n; j++) {
			if (!isConfilct(it, list.get(j))) {
				return j;
			}
		}
		return -1;
	}

	private List<Integer> findConfilcts(List<Interval> list, int i) {
		List<Integer> result = new ArrayList<>();
		Interval it = list.get(i);
		int n = list.size();
		for (int j = i + 1; j < n; j++) {
			if (isConfilct(it, list.get(j))) {
				result.add(j);
			}
		}
		return result;
	}

	private boolean isConfilct(Interval it, Interval next) {
		return it.end > next.start;
	}

	private int findNextDiffStart(Interval[] intervals, int index) {
		int len = intervals.length;
		Interval it = intervals[index];
		int result = len;
		for (int i = index + 1; i < len; i++) {
			if (intervals[i].start != it.start) {
				result = i;
				break;
			}
		}
		return result;
	}
}
