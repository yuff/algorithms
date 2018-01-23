package com.leetcode.mytest;

import java.util.*;

/**
 * unfinished
 */

public class UniqueSubstringsInWraparoundString {
	public static void main(String[] args) {
		UniqueSubstringsInWraparoundString us = new UniqueSubstringsInWraparoundString();
		System.out.println(us.findSubstringInWraproundString("zab"));
		System.out.println(us.findSubstringInWraproundString("cac"));
	}

	public int findSubstringInWraproundString(String p) {
		if (p == null || p.length() == 0) {
			return 0;
		}
		else if (p.length() == 1) {
			return 1;
		}
		Map<Integer, Set<String>> map = new HashMap<>();
		boolean[] added = new boolean[26];
		int n = p.length(), sId = 0, pre = p.charAt(0) - 'a', cId = 1;
		while (cId < n) {
			int cur = p.charAt(cId) - 'a';
			if ((pre + 1) % 26 == cur) {
				pre = cur;
				cId++;
			}
			else {
				int len = cId - sId;
				if (map.get(len) == null) {
					map.put(len, new HashSet<>());
				}
				map.get(len).add(p.substring(sId, cId));
				// if (len > 1) {
				// if ()
				// } else {
				// if (!added[pre]) {
				// list.add(len);
				// added[pre] = true;
				// }
				// }
				sId = cId;
				pre = cur;
				cId++;
			}
		}
		int result = 0;
		int len = cId - sId;
		if (map.get(len) == null) {
			map.put(len, new HashSet<>());
		}
		map.get(len).add(p.substring(sId, cId));
		// for(int i: list) {
		// result += (i * (i + 1)) >> 1;
		// }
		return result;
	}
}
