package com.leetcode.newround;

import java.util.*;

public class MapSumPairs {
	
	public static void main(String[] args) {
		MapSumPairs msp = new MapSumPairs();
		System.out.println(msp.sum("ap"));
		msp.insert("apple", 4);
		msp.insert("app", 3);
		System.out.println(msp.sum("ap"));
	}
	
	Map<String, Integer> map;
	Set<String> set;

	/** Initialize your data structure here. */
	public MapSumPairs() {
		map = new HashMap<>();
		set = new TreeSet<>();
	}

	public void insert(String key, int val) {
		map.put(key, val);
		set.add(key);
	}

	public int sum(String prefix) {
		int result = 0;
		Iterator<String> iterator = set.iterator();
		boolean found = false;
		while (iterator.hasNext()) {
			String s = iterator.next();
			if (s.startsWith(prefix)) {
				result += map.get(s);
				found = true;
			}
			else if (found) {
				break;
			}
		}
		return result;
	}
}
