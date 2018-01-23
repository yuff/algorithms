package com.leetcode.newround;

import java.util.*;

public class LFUCache {
	public static void main(String[] args) {
		LFUCache lfu = new LFUCache(2);
		lfu.put(1, 1);
		lfu.put(2, 2);
		System.out.println(lfu.get(1));
		lfu.put(3, 3);
		System.out.println(lfu.get(2));
		System.out.println(lfu.get(3));
		lfu.put(4, 4);
		System.out.println(lfu.get(1));
		System.out.println(lfu.get(3));
		System.out.println(lfu.get(4));
	}

	int capacity;
	Map<Integer, Integer> values;
	Map<Integer, Integer> counts;
	Map<Integer, LinkedHashSet<Integer>> lists;
	int min = -1;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		values = new HashMap<>();
		counts = new HashMap<>();
		lists = new HashMap<>();
	}

	public int get(int key) {
		int result = -1;
		if (values.get(key) != null) {
			result = values.get(key);
			int count = counts.get(key);
			LinkedHashSet<Integer> list = lists.get(count);
			if (count == min && list.size() == 1) {
				lists.remove(count);
				min = count + 1;
			}
			else {
				list.remove(key);
			}
			LinkedHashSet<Integer> addOneList = lists.getOrDefault(count + 1, new LinkedHashSet<>());
			addOneList.add(key);
			lists.put(count + 1, addOneList);
			counts.put(key, count + 1);
		}
		return result;
	}

	public void put(int key, int value) {
		if (capacity <= 0) {
			return;
		}
		if (values.containsKey(key)) {
			values.put(key, value);
			get(key);
		}
		else {
			if (values.size() >= capacity) {
				LinkedHashSet<Integer> minList = lists.get(min);
				int v = minList.iterator().next();
				minList.remove(v);
				counts.remove(v);
				values.remove(v);
			}
			values.put(key, value);
			counts.put(key, 1);
			min = 1;
			LinkedHashSet<Integer> list = lists.getOrDefault(1, new LinkedHashSet<>());
			list.add(key);
			lists.put(1, list);
		}
	}
}
