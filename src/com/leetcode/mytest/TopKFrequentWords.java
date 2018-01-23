package com.leetcode.mytest;

import java.util.*;

public class TopKFrequentWords {
	public static void main(String[] args) {
		TopKFrequentWords tfw = new TopKFrequentWords();
		String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		System.out.println(tfw.topKFrequent(words , 3));
	}
	public List<String> topKFrequent(String[] words, int k) {
		if (words == null || words.length == 0) {
			return new ArrayList<>();
		}
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			if (map.get(word) == null) {
				map.put(word, 1);
			}
			else {
				map.put(word, map.get(word) + 1);
			}
		}
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o1.getValue() == o2.getValue()) {
					return o1.getKey().compareTo(o2.getKey());
				}
				else {
					return o2.getValue() - o1.getValue();
				}
			}
		});
		List<String> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			result.add(list.get(i).getKey());
		}
		return result;
	}
}
