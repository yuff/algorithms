package com.leetcode.newround;

import java.util.*;

public class ShortestCompletingWord {
	public static void main(String[] args) {
		ShortestCompletingWord sc = new ShortestCompletingWord();
		String[] words = new String[]{"step", "steps", "stripe", "stepple", "looks", "pest", "stew", "show"};
		System.out.println(sc.shortestCompletingWord("1s3 PSt", words ));
	}
	public String shortestCompletingWord(String licensePlate, String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}
		Map<String, Integer> map = buildWordMap(words);
		List<Map.Entry<String, Integer>> list = new ArrayList<>();
		list.addAll(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o1.getKey().length() == o2.getKey().length()) {
					return o1.getValue() - o2.getValue();
				}
				else {
					return o1.getKey().length() - o2.getKey().length();
				}
			}
		});
		for (Map.Entry<String, Integer> entry : list) {
			String word = entry.getKey();
			if (canFit(licensePlate, word)) {
				return word;
			}
		}
		return "";
	}

	private boolean canFit(String licensePlate, String word) {
		if (licensePlate == null || licensePlate.isEmpty()) {
			return true;
		}
		int[] need = new int[26];
		int count = 0;
		for (int i = 0; i < licensePlate.length(); i++) {
			char c = licensePlate.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				int id = (c >= 'a' && c <= 'z') ? c - 'a' : c - 'A';
				need[id]++;
				count++;
			}
		}
		if (word.length() < count) {
			return false;
		}
		for(int i = 0; i < word.length(); i++) {
			int id = word.charAt(i) - 'a';
			if (need[id] > 0) {
				need[id]--;
				count--;
			}
		}
		return count == 0;
	}

	private Map<String, Integer> buildWordMap(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		int n = words.length;
		for (int i = 0; i < n; i++) {
			map.put(words[i], i);
		}
		return map;
	}
}
