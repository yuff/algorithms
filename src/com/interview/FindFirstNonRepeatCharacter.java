package com.interview;

import java.util.*;

public class FindFirstNonRepeatCharacter {
	public static void main(String[] args) {
		FindFirstNonRepeatCharacter ff = new FindFirstNonRepeatCharacter();
		System.out.println(ff.findFirstNonRepeatChar("google"));
		System.out.println(ff.findFirstNonRepeatChar("dad"));
		System.out.println(ff.findFirstNonRepeatChar("dd"));
	}
	public String findFirstNonRepeatChar(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		char[] arr = s.toCharArray();
		Map<Character,Integer> show = new HashMap<>();
		for(char c: arr) {
			int count = show.getOrDefault(c, 0);
			show.put(c, count+1);
		}
		StringBuilder builder = new StringBuilder();
		for(char c : arr) {
			if (show.get(c) == 1) {
				builder.append(c);
				break;
			}
		}
		return builder.toString();
	}
}
