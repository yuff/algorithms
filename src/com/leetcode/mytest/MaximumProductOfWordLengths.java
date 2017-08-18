package com.leetcode.mytest;

public class MaximumProductOfWordLengths {

	public static void main(String[] args) {
		MaximumProductOfWordLengths mp = new MaximumProductOfWordLengths();
		String[] words = new String[] {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		String[] words1 = new String[] {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
		String[] words2 = new String[] {"a", "aa", "aaa", "aaaa"};
		System.out.println(mp.maxProduct(words));
		System.out.println(mp.maxProduct(words1));
		System.out.println(mp.maxProduct(words2));
	}

	public int maxProduct(String[] words) {
		if (words == null || words.length == 0) {
			return 0;
		}
		int n = words.length;
		int[] nums = new int[n];
		int[] maxs = new int[n];
		int i = 0;
		for (String w : words) {
			nums[i] = convertToNum(w);
			for (int j = 0; j < i; j++) {
				int a = nums[j] & nums[i];
				if (a == 0 && w.length() > maxs[j]) {
					maxs[j] = w.length();
				}
			}
			i++;
		}
		int max = 0;
		for (int k = 0; k < n; k++) {
			int tmp = words[k].length() * maxs[k];
			if (tmp > max) {
				max = tmp;
			}
		}
		return max;
	}

	private int convertToNum(String w) {
		int[] bits = new int[26];
		int n = w.length();
		for (int i = 0; i < n; i++) {
			int index = w.charAt(i) - 'a';
			bits[index] = 1;
		}
		int result = 0;
		for (int i = 0; i < 26; i++) {
			if (bits[i] == 1) {
				result += 1 << i;
			}
		}
		return result;
	}
}
