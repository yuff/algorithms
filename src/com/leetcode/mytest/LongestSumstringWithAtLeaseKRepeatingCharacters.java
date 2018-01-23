package com.leetcode.mytest;

import java.util.*;

public class LongestSumstringWithAtLeaseKRepeatingCharacters {
	public static void main(String[] args) {
		LongestSumstringWithAtLeaseKRepeatingCharacters ls = new LongestSumstringWithAtLeaseKRepeatingCharacters();
		System.out.println(ls.longestSubstring("ababbc", 2));
//		System.out.println(ls.longestSubstring("aaabbb", 3));
//		System.out.println(ls.longestSubstring("abaabb", 3));
	}

	public int longestSubstring(String s, int k) {
		if (s == null || s.length() < k) {
			return 0;
		}
        if (k == 1) {
            return s.length();
        }
        Map<Character,Integer> map = new HashMap<>();
		int n = s.length();
        for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c,1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        if (Collections.min(map.values()) >= k) {
            return n;
        }
        return longestSubstring(s, 0, s.length() - 1, k);
	}
    private int longestSubstring(String s, int start, int end, int k) {
        int[] count = new int[26];
        for(int i = start; i <= end; i++) {
            count[s.charAt(i) - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < min) {
                min = count[i];
            }
        }
        if (min >= k) {
            return end - start + 1;
        } else {
            int result = 0;
                for(int i = 0; i < 26; i++) {
                if (count[i] > 0 && count[i] < k) {
                    for(int j = start; j <= end; j++) {
                        if (s.charAt(j) - 'a' == i) {
                            int left = longestSubstring(s, start, j - 1, k);
                            int right = longestSubstring(s, j + 1, end, k); 
                            result = Math.max(left, right);
                            break;
                        }

                    }
                }
            } 
            return result;
        }
    }
    
	public int longestSubstring1(String s, int k) {
		if (s == null || s.length() < k) {
			return 0;
		}
		if (k == 1) {
			return s.length();
		}
		int n = s.length(), result = 0;
		Info[][] infos = new Info[n][n];
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			infos[i][i] = new Info();
			infos[i][i].map.put(c, 1);
			infos[i][i].min = 1;

			if (i > 0) {
				infos[0][i] = count(infos[0][i - 1], c, false);
			}
			if (infos[0][i].min >= k && i + 1 > result) {
				result = i + 1;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				infos[i][j] = count(infos[i - 1][j], s.charAt(i - 1), true);
				if (infos[i][j].min >= k && j - i + 1 > result) {
					result = j - i + 1;
				}
			}
		}
		return result;
	}

	private Info count(Info pre, char c, boolean exclude) {
		Info info = new Info();
		info.min = pre.min;
		info.map.putAll(pre.map);
		if (exclude) {
			int count = info.map.get(c) - 1;
			if (count == 0) {
				info.map.remove(c);
				info.min = Collections.min(info.map.values());
			} else {
				info.map.put(c, count);
				if (count < info.min) {
					info.min = count;
				}
			}
		}
		else {
			int count = info.map.get(c) == null ? 1 : info.map.get(c) + 1;
			info.map.put(c, count);
			if (count == 1) {
				info.min = 1;
			}
			else {
				info.min = Collections.min(info.map.values());
			}
		}
		return info;
	}

	class Info {
		Map<Character, Integer> map = new HashMap<>();
		int min;
	}
}
