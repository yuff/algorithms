package com.leetcode.mytest;

import java.util.*;

public class AllOne {
	public static void main(String[] args) {
		AllOne ao = new AllOne();
		ao.inc("Hello");
		System.out.println(ao.getMaxKey());
		System.out.println(ao.getMinKey());
	}

	Map<String, KeyValue> map;
	PriorityQueue<KeyValue> maxQueue;
	PriorityQueue<KeyValue> minQueue;

	/** Initialize your data structure here. */
	public AllOne() {
		map = new HashMap<>();
		maxQueue = new PriorityQueue<>(new Comparator<KeyValue>() {
			@Override
			public int compare(KeyValue e1, KeyValue e2) {
				return e2.value - e1.value;
			}
		});
		minQueue = new PriorityQueue<>(new Comparator<KeyValue>() {
			@Override
			public int compare(KeyValue e1, KeyValue e2) {
				return e1.value - e2.value;
			}
		});

	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
		KeyValue origin = map.getOrDefault(key, new KeyValue(key));
		maxQueue.remove(origin);
		minQueue.remove(origin);
		origin.key = key;
		origin.value += 1;
		map.put(key, origin);
		maxQueue.add(origin);
		minQueue.add(origin);
	}

	/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	public void dec(String key) {
		if (map.get(key) == null) {
			return;
		}
		KeyValue origin = map.get(key);
		maxQueue.remove(origin);
		minQueue.remove(origin);
		origin.value -= 1;
		if (origin.value == 0) {
			map.remove(key);
		}
		else {
			map.put(key, origin);
			maxQueue.add(origin);
			minQueue.add(origin);
		}

	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		return maxQueue.isEmpty() ? "" : maxQueue.peek().key;
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		return minQueue.isEmpty() ? "" : minQueue.peek().key;
	}
}

class KeyValue {
	KeyValue(String key) {
		this.key = key;
		this.value = 0;
	}

	String key;
	Integer value;
}
