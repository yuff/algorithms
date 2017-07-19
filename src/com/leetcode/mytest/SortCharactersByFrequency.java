package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortCharactersByFrequency {
	public String frequencySort(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		Map<Character, Integer> map = new HashMap<>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (map.get(c) == null) {
				map.put(c, 0);
			}
			int v = map.get(c) + 1;
			map.put(c, v);
		}
		Map<Integer, List<Character>> fMap = new HashMap<>();
		Set<Character> keys = map.keySet();
		for (char c : keys) {
			int v = map.get(c);
			if (fMap.get(v) == null) {
				fMap.put(v, new ArrayList<Character>());
			}
			fMap.get(v).add(c);
		}
		List<Integer> fList = new ArrayList<>();
		fList.addAll(fMap.keySet());
		Collections.sort(fList, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				int i1 = (int) o1;
				int i2 = (int) o2;
				if (i1 > i2) {
					return -1;
				}
				else if (i1 == i2) {
					return 0;
				}
				else {
					return 1;
				}
			}
		});
		char[] result = new char[length];
		int index = 0;
		for (int i : fList) {
			List<Character> l = fMap.get(i);
			for (char c : l) {
				for (int j = 0; j < i; j++) {
					result[index++] = c;
				}
			}
		}
		return new String(result);
	}
}
