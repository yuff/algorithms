package com.leetcode.mytest;

import java.util.*;

public class FindAllAnagramsInAString {
	public static void main(String[] args) {
		FindAllAnagramsInAString fa = new FindAllAnagramsInAString();
		System.out.println(fa.findAnagrams("cbaebabacd", "c"));
	}
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.isEmpty() || p.isEmpty()) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        int[] pFreq = new int[26];
        int m = s.length(), n = p.length();
        for(int i = 0; i < n;i++) {
            pFreq[p.charAt(i) - 'a'] += 1;
        }
        for(int i = 0; i <= m - n; i++) {
            int[] tmp = new int[26];
            System.arraycopy(pFreq,0, tmp, 0, 26);
            char c = s.charAt(i);
            if (tmp[c-'a'] == 0) {
                continue;
            } else {
                int count = 1;
                tmp[c-'a'] -=1;
                if (count == n) {
                	result.add(i);
                	continue;
                }
                for(int j = i + 1; j < m; j++) {
                    char d = s.charAt(j);
                    if (tmp[d - 'a'] == 0) {
                        break;
                    } else {
                        tmp[d-'a'] -=1;
                        count++;
                        if (count == n) {
                            result.add(i);
                            break;
                        }
                    }
                }
            }            
        }
        return result;
    }
}
