package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExclusiveTimeOfFunctions {
	public static void main(String[] args) {
		ExclusiveTimeOfFunctions et = new ExclusiveTimeOfFunctions();
		List<String> logs = new ArrayList<>();
		logs.add("0:start:0");
		logs.add("0:start:1");
		logs.add("0:start:2");
		logs.add("0:end:3");
		logs.add("0:end:4");
		logs.add("0:end:5");
		int[] result = et.exclusiveTime(1, logs);
		System.out.println(result[0]);
		// System.out.println(result[1]);
	}

	public int[] exclusiveTime(int n, List<String> logs) {
		Map<int[], Integer> map = new HashMap<>();
		parseLogs(map, logs);
		List<Map.Entry<int[], Integer>> list = new ArrayList<>();
		list.addAll(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<int[], Integer>>() {
			@Override
			public int compare(Map.Entry<int[], Integer> o1, Map.Entry<int[], Integer> o2) {
				if (o1.getKey()[0] == o2.getKey()[0]) {
					return o2.getKey()[1] - o1.getKey()[1];
				}
				else {
					return o1.getKey()[0] - o2.getKey()[0];
				}
			}
		});
		int[] exeTime = new int[n];
		int len = list.size();
		for (int i = 0; i < len; i++) {
			Map.Entry<int[], Integer> e = list.get(i);
			exeTime[e.getValue()] += calExeTime(i, list);
		}
		return exeTime;
	}

	private void parseLogs(Map<int[], Integer> map, List<String> logs) {
		LinkedList<int[]> stack = new LinkedList<>();
		for (String log : logs) {
			String[] strs = log.split(":");
			if ("start".equals(strs[1])) {
				int[] tmp = new int[2];
				tmp[0] = Integer.valueOf(strs[0]);
				tmp[1] = Integer.valueOf(strs[2]);
				stack.push(tmp);
			}
			else if ("end".equals(strs[1])) {
				int[] tmp = new int[2];
				tmp[0] = Integer.valueOf(strs[0]);
				tmp[1] = Integer.valueOf(strs[2]);

				int[] start = stack.pop();
				if (start[0] != tmp[0]) {
					throw new RuntimeException("log format error");
				}
				else {
					int[] r = new int[2];
					r[0] = start[1];
					r[1] = tmp[1];
					map.put(r, start[0]);
				}
			}
		}
	}

	private int calExeTime(int i, List<Map.Entry<int[], Integer>> list) {
		Map.Entry<int[], Integer> e = list.get(i);
		int n = list.size();
		int startIndex = e.getKey()[0];
		int endIndex = e.getKey()[1];

		int start = -1;
		int end = -1;
		int base = endIndex - startIndex + 1;
		int minus = 0;
		for (int j = i + 1; j < n; j++) {
			int[] tmp = list.get(j).getKey();
			if (tmp[0] > endIndex || tmp[1] > endIndex) {
				break;
			}
			else {
				if (tmp[0] > start && tmp[1] > end) {
					start = tmp[0];
					end = tmp[1];
					minus += (end - start + 1);
				}
			}
		}
		return base - minus;
	}
}
