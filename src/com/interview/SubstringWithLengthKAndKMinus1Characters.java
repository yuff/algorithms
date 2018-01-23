package com.interview;

import java.util.*;

/**
 * 
 * count number of substrings with k-1 distinct characters and length K
 *
 */
public class SubstringWithLengthKAndKMinus1Characters {

	public static void main(String[] args) {
		SubstringWithLengthKAndKMinus1Characters sw = new SubstringWithLengthKAndKMinus1Characters();
		System.out.println(sw.substringOfLengthKWithK1Characters("abcaabcdabcadfae", 4));
	}

	public List<String> substringOfLengthKWithK1Characters(String s, int k) {
		List<String> result = new ArrayList<>();
		if (s == null || s.length() < k || k < 1) {
			return result;
		}
		int n = s.length(), start = 0;
		Map<Character, Integer> map = new HashMap<>();
		int duplicatedId = -1;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (map.get(c) == null) {
				map.put(c, i);
			}
			else {
				if (duplicatedId <= start) {
					duplicatedId = i;
				}
				else {
					int curCharId = map.get(c);
					int firstDuplicateCharId = map.get(s.charAt(duplicatedId));
					start = Math.max(curCharId, firstDuplicateCharId) + 1;
					if (curCharId < firstDuplicateCharId) {
						map.put(c, i);
					}
					else {
						map.put(s.charAt(duplicatedId), duplicatedId);
						duplicatedId = i;
					}
				}
			}
			if (i - start + 1 == k) {
				char cStart = s.charAt(start);
				if (duplicatedId > start) {
					result.add(s.substring(start, i + 1));
				}
				map.remove(cStart);
				if (duplicatedId > start && s.charAt(duplicatedId) == cStart) {
					map.put(cStart, duplicatedId);
					duplicatedId = -1;
				}
				start++;
			}
		}
		return result;
	}
}
