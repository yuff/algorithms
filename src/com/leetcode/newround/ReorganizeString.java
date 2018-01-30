package com.leetcode.newround;

import java.util.*;

public class ReorganizeString {
	public static void main(String[] args) {
		ReorganizeString rs = new ReorganizeString();
		System.out.println(rs.reorganizeString("aa"));
	}
	public String reorganizeString(String s) {
		if (s == null || s.isEmpty() || s.length() < 2) {
			return s;
		}
		Map<Character, Integer> map = new HashMap<>();
		int mostFreq = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int freq = map.getOrDefault(c, 0);
			map.put(c, freq + 1);
			mostFreq = Math.max(mostFreq, map.get(c));
		}
		if (mostFreq > (s.length() + 1) / 2) {
			return "";
		}

		PriorityQueue<Map.Entry<Character, Integer>> maxQueue =
		                new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
			                @Override
			                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				                return o2.getValue() - o1.getValue();
			                }
		                });
		maxQueue.addAll(map.entrySet());
		StringBuilder sb = new StringBuilder();
		while (!maxQueue.isEmpty()) {
			Map.Entry<Character, Integer> maxEntry = maxQueue.poll();
			Map.Entry<Character, Integer> secondEntry = null;
			if (!maxQueue.isEmpty()) {
				secondEntry = maxQueue.poll();
			}
			sb.append(maxEntry.getKey());
			maxEntry.setValue(maxEntry.getValue() - 1);
			if (maxEntry.getValue() > 0) {
				maxQueue.add(maxEntry);
			}
			if (secondEntry != null) {
				sb.append(secondEntry.getKey());
				secondEntry.setValue(secondEntry.getValue() - 1);
				if (secondEntry.getValue() > 0) {
					maxQueue.add(secondEntry);
				}
			}
		}
		return sb.toString();
	}
}
