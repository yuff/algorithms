package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructOriginalDigitsFromEnglish {

	private static String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

	public static void main(String[] args) {
		ReconstructOriginalDigitsFromEnglish r = new ReconstructOriginalDigitsFromEnglish();
		System.out.println(r.originalDigits("owoztneoer"));
	}
    public String originalDigits(String s) {
    	List<String> digitArr = Arrays.asList(digits);
    	if (s == null ||s.isEmpty()) {
    		return s;
    	}
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
        	char c = s.charAt(i);
        	if (map.get(c) == null) {
        		map.put(c, 1);
        	} else {
        		map.put(c, map.get(c) + 1);
        	}
        }
        int[] nums = new int[10];
        List<Map.Entry<Character, List<String>>> list = preprocessDigits();
        for(Map.Entry<Character, List<String>> entry: list) {
        	char c = entry.getKey();
        	List<String> values = entry.getValue();
        	for(String value: values) {
        		if (map.get(c) != null && map.get(c) > 0) {
        			int count = map.get(c);
        			int index = digitArr.indexOf(value);
        			nums[index] = count;
        			int len = value.length();
        			for(int i = 0; i < len; i++) {
        				char t = value.charAt(i);
        				map.put(t, map.get(t) - count);
        			}
        		}
        	}
        }
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 10; i++) {
        	int count = nums[i];
        	while(count > 0) {
        		builder.append(i);
        		count--;
        	}
        }
        return builder.toString();
    }

	private List<Map.Entry<Character, List<String>>> preprocessDigits() {
		Map<Character, List<String>> map = new HashMap<>();
		for(String s: digits) {
			int n = s.length();
			for(int i = 0; i < n; i++) {
				char c = s.charAt(i);
				if (map.get(c) == null) {
					map.put(c, new ArrayList<String>());
				}
				map.get(c).add(s);
			}
		}
		PriorityQueue<Map.Entry<Character, List<String>>> queue = new PriorityQueue<>( new Comparator<Map.Entry<Character, List<String>>>() {
			@Override
			public int compare(Map.Entry<Character, List<String>> o1, Map.Entry<Character, List<String>> o2) {
				return o1.getValue().size() - o2.getValue().size();
			}
		});
		queue.addAll(map.entrySet());
		List<Map.Entry<Character, List<String>>> list = new ArrayList<>();
		List<String> alreadyHad = new ArrayList<>();
		while(!queue.isEmpty()) {
			Map.Entry<Character, List<String>> entry = queue.poll();
			entry.getValue().removeAll(alreadyHad);
			alreadyHad.addAll(entry.getValue());
			if (entry.getValue().size() > 0) {
				list.add(entry);
			}
		}
		System.out.println(list);
		return list;
	}
}
