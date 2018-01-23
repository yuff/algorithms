package com.leetcode.mytest;

import java.util.*;

public class MinimumWindowSubstring {
	public static void main(String[] args) {
		MinimumWindowSubstring mw = new MinimumWindowSubstring();
//		System.out.println(mw.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(mw.minWindow("a", "b") + ",result");
		System.out.println(mw.minWindow("a", "babc") + ",result");
	}
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return "";
        }
        int count = t.length(), m = t.length(), n = s.length();
        int[] result = new int[]{-1, Integer.MAX_VALUE};
        Map<Character,Integer> tMap = new HashMap<>();
        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();
        for(int i = 0; i < m; i++) {
            int origin = tMap.getOrDefault(tArr[i], 0);
            tMap.put(tArr[i], origin + 1);
        }
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            char c = sArr[i];
            if (tMap.get(c) != null) {
                int value = tMap.get(c);
                tMap.put(c, value - 1);
                list.add(i);
                if (value > 0) {
                    count--;
                }
                while (count == 0) {
                    int start = list.getFirst();
                    int end = list.getLast();
                    if (end - start + 1 < result[1]) {
                        result[0] = start;
                        result[1] = end - start + 1;
                    }
                    char r = sArr[list.removeFirst()];
                    int rValue = tMap.get(r);
                    tMap.put(r, rValue + 1);
                    if (rValue == 0) {
                        count++;
                    }
                }
            }
        }
        return result[0] == -1? "" :s.substring(result[0], result[0] + result[1]);
    }
}
