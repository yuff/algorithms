package com.interview;

import java.util.*;

/**
 * 
 * Given a string and an integer K, return a list of substring with exactly k distinct characters
 *
 */
public class SubStringOfExactlyKDistinctCharacters {

	public static void main(String[] args) {
		SubStringOfExactlyKDistinctCharacters ss = new SubStringOfExactlyKDistinctCharacters();
		System.out.println(ss.substringOfKDistinctCharacters("aabbacaabbcccdd", 3));
	}

	public List<String> substringOfKDistinctCharacters(String s, int k) {
		List<String> result = new ArrayList<>();
		if (s == null || s.length() < k) {
			return result;
		}
		int n = s.length();
		for (int i = 0; i < n; i++) {
			Map<Character, Integer> map = new HashMap<>();
			int count = 0;
			for (int j = i; j < n; j++) {
				char c = s.charAt(j);
				if (map.get(c) == null) {
					map.put(c, 1);
					count++;
				}
				else {
					map.put(c, map.get(c) + 1);
				}
				if (count == k) {
					result.add(s.substring(i, j + 1));
				}
			}
		}
		return result;
	}
}
