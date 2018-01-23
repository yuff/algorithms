package com.leetcode.newround;

import java.util.*;

public class RemoveDuplicateLetters {
	public static void main(String[] args) {
		RemoveDuplicateLetters rd = new RemoveDuplicateLetters();
		System.out.println(rd.removeDuplicateLetters("demabcehaosdfleofiasdflmjfeoiudyyqpalkdfnczoe"));
	}

	public String removeDuplicateLetters(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		char[] arr = s.toCharArray();
		int[] count = new int[26];
		boolean[] visit = new boolean[26];
		int n = s.length();
		for (int i = 0; i < n; i++) {
			count[arr[i] - 'a']++;
		}
		LinkedList<Character> stack = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			char c = arr[i];
			int id = c  - 'a';
			count[id]--;
			if (!visit[id]) {
				while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
					visit[stack.pop() - 'a'] = false;
				}
				stack.push(c);
				visit[id] = true;
			}
		}
		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}	
		return builder.reverse().toString();
	}
}
