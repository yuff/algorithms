package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 
 * Given a List of words, return the words that can be typed using letters of alphabet on only one
 * row's of American keyboard like the image below. Example 1: Input: ["Hello", "Alaska", "Dad",
 * "Peace"] Output: ["Alaska", "Dad"] Note: You may use one character in the keyboard more than
 * once. You may assume the input string will only contain letters of alphabet.
 */
public class KeyboardRow {

	private final static char[] c1 = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
	private final static char[] c2 = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';', '\''};
	private final static char[] c3 = {'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/', '<', '>', '?'};

	public static void main(String[] args) {
		String[] s1 = {"Hello", "Alaska", "Dad", "Peace"};
		String[] result = new KeyboardRow().findWords(s1);
		for(String s: result) {			
			System.out.println(s);
		}

	}

	public String[] findWords(String[] words) {
		Map<Character, Boolean> m1 = new HashMap<>();
		Map<Character, Boolean> m2 = new HashMap<>();
		Map<Character, Boolean> m3 = new HashMap<>();
		for (char c : c1) {
			m1.put(c, true);
		}
		for (char c : c2) {
			m2.put(c, true);
		}
		for (char c : c3) {
			m3.put(c, true);
		}
		List<String> result = new ArrayList<>();
		int cur = 0;
		for (String word : words) {
			if (inOneRow(m1, m2, m3, word)) {
				result.add(word);
			}
		}
		return result.toArray(new String[result.size()]);
	}

	private boolean inOneRow(Map<Character, Boolean> m1, Map<Character, Boolean> m2, Map<Character, Boolean> m3,
	                         String word) {
		if (!word.isEmpty()) {
			word = word.toLowerCase();
			char firstChar = word.charAt(0);
			if (m1.get(firstChar) != null && m1.get(firstChar)) {
				return inOneRow(m1, word);
			}
			if (m2.get(firstChar) != null && m2.get(firstChar)) {
				return inOneRow(m2, word);
			}
			if (m3.get(firstChar) != null && m3.get(firstChar)) {
				return inOneRow(m3, word);
			}
		}
		return false;
	}

	private boolean inOneRow(Map<Character, Boolean> m1, String word) {
		char[] wordArray = word.toCharArray();
		for (char c : wordArray) {
			if (m1.get(c) == null || !m1.get(c)) {
				return false;
			}
		}
		return true;
	}
}
