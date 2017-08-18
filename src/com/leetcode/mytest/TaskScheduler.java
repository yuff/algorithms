package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TaskScheduler {
	public static void main(String[] args) {
		TaskScheduler ts = new TaskScheduler();
		char[] tasks = new char[] {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		System.out.println(ts.leastInterval(tasks, 2));
	}

	public int leastInterval(char[] tasks, int n) {
		if (n < 0 || tasks == null || tasks.length == 0) {
			return 0;
		}
		if (n == 0) {
			return tasks.length;
		}
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> distances = new HashMap<>();
		for (char c : tasks) {
			distances.put(c, n);
			if (map.get(c) == null) {
				map.put(c, 1);
			}
			else {
				map.put(c, map.get(c) + 1);
			}
		}

		PriorityQueue<Map.Entry<Character, Integer>> queue =
		                new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
			                @Override
			                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				                return o2.getValue() - o1.getValue();
			                }
		                });
		queue.addAll(map.entrySet());
		int count = 0;
		List<String> result = new ArrayList<>();
		while (queue.size() > 0) {
			int idle = addIdle(distances, n);
			for (int i = 0; i < idle; i++) {
				result.add("idle->");
			}
			count += idle;
			Iterator<Map.Entry<Character, Integer>> itr = queue.iterator();
			while (itr.hasNext()) {
				Map.Entry<Character, Integer> e = itr.next();
				char c = e.getKey();
				if (distances.get(c) >= n) {
					count++;
					result.add(String.valueOf(c) + "->");
					updateDistance(distances, c);
					itr.remove();
					e.setValue(e.getValue() - 1);
					if (e.getValue() > 0) {
						queue.add(e);
					}
					else {
						distances.remove(e.getKey());
					}
					break;
				}
			}
		}
		System.out.println(result);
		return count;
	}

	private void updateDistance(Map<Character, Integer> distances, char c) {
		Set<Character> keys = distances.keySet();
		for (char key : keys) {
			if (key == c) {
				distances.put(c, 0);
			}
			else {
				distances.put(key, distances.get(key) + 1);
			}
		}
	}

	private int addIdle(Map<Character, Integer> distances, int n) {
		Set<Character> keys = distances.keySet();
		int max = 0;
		for (char key : keys) {
			if (distances.get(key) > max) {
				max = distances.get(key);
			}
		}
		if (max >= n) {
			return 0;
		}
		else {
			int r = n - max;
			for (char key : keys) {
				distances.put(key, distances.get(key) + r);
			}
			return r;
		}
	}
}
