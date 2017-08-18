package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

public class LongestRepeatingCharacterReplacement {
	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement lr = new LongestRepeatingCharacterReplacement();
		System.out.println(lr.characterReplacement("IMNJJTRMJEGMSOLSCCQICIHLQIOGBJAEHQOCRAJQMBIBATGLJDTBNCPIFRDLRIJHRABBJGQAOLIKRLHDRIGERENNMJSDSSMESSTR",
		                                           2));
	}

	public int characterReplacement(String s, int k) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		List<int[]>[] list = new List[26];
		int n = s.length();
		int start = 0, end = 0;
		char pre = s.charAt(0);
		while (start < n && end < n) {
			char c = s.charAt(end);
			if (c == pre) {
				end++;
			}
			else {
				int[] tmp = new int[2];
				tmp[0] = start;
				tmp[1] = end - 1;
				int index = pre - 'A';
				if (list[index] == null) {
					list[index] = new ArrayList<int[]>();
				}
				list[index].add(tmp);
				start = end;
				pre = c;
				end++;
			}
		}

		int[] tmp = new int[2];
		tmp[0] = start;
		tmp[1] = end - 1;
		int index = pre - 'A';
		if (list[index] == null) {
			list[index] = new ArrayList<int[]>();
		}
		list[index].add(tmp);

		int cur = 0;
		for (int i = 0; i < 26; i++) {
			List<int[]> l = list[i];
			int m = l == null ? 0 : l.size();
			for (int j = 0; j < m; j++) {
				int r = k;
				int[] first = l.get(j);
				int t = first[1] - first[0] + 1;
				int id = j + 1;
				while (id < m && (l.get(id)[0] - first[1] - 1) <= r) {
					int[] after = l.get(id);
					int gap = l.get(id)[0] - first[1] - 1;
					r -= gap;
					t += (gap + after[1] - after[0] + 1);
					first = after;
					id++;
				}
				t = Math.min(n, t + r);
				if (t > cur) {
					cur = t;
					if (t == n) {
						break;
					}
				}
			}
		}
		return cur;
	}
}
