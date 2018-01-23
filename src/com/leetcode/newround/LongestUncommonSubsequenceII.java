package com.leetcode.newround;

import java.util.*;

public class LongestUncommonSubsequenceII {
	public static void main(String[] args) {
		LongestUncommonSubsequenceII lus = new LongestUncommonSubsequenceII();
		String[] strs = new String[] {"eeb", "eab", "eaeb", "eaeb"};
		System.out.println(lus.findLUSlength(strs));
	}

	public int findLUSlength(String[] strs) {
		if (strs == null || strs.length == 0) {
			return 0;
		}
		Map<String, Integer> map = new HashMap<>();
		for (String s : strs) {
			int pre = map.getOrDefault(s, 0);
			map.put(s, pre + 1);
		}
		List<Map.Entry<String, Integer>> list = new ArrayList<>();
		list.addAll(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getKey().length() - o1.getKey().length();
			}
		});
		List<String> dupList = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : list) {
			if (entry.getValue() > 1) {
				dupList.add(entry.getKey());
			}
			else {
				if (noLUS(dupList, entry.getKey())) {
					return entry.getKey().length();
				}
				else {
					dupList.add(entry.getKey());
				}
			}
		}
		return -1;
	}

	private boolean noLUS(List<String> list, String key) {
		for (String s : list) {
			if (lcs(s, key)) {
				return false;
			}
		}
		return true;
	}

	private boolean lcs(String s1, String s2) {
		if (s2.length() > s1.length()) {
			return false;
		}
		int n1 = s1.length(), n2 = s2.length(), i = 0, j = 0;
		while (i < n1 && j < n2) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(j);
			if (c1 == c2) {
				i++;
				j++;
			}
			else {
				i++;
			}
		}
		return j == n2;
	}
}
