package com.leetcode.newround;

import java.util.*;

public class MagicDictionary {
	
	public static void main(String[] args) {
		MagicDictionary md = new MagicDictionary();
		md.buildDict(new String[]{"hello","hallo","leetcode"});
		System.out.println(md.search("hello"));
		System.out.println(md.search("hallo"));
		System.out.println(md.search("hell"));
		System.out.println(md.search("leetcoded"));
	}
	
	Map<Integer, List<String>> map = new HashMap<>();
    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String d: dict) {
        	int len = d.length();
        	List<String> list = map.getOrDefault(len, new ArrayList<>());
        	list.add(d);
        	map.put(len, list);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
        	return false;
        }
        int n = word.length();
        List<String> list = map.get(n);
        if (list == null || list.isEmpty()) {
        	return false;
        } else {
        	for(String s: list) {
        		if (matchOneDiff(s, word)) {
        			return true;
        		}
        	}
        }
        return false;
    }

	private boolean matchOneDiff(String s, String word) {
		int n = s.length(), diff = 0;
		for(int i = 0; i < n; i++) {
			if (s.charAt(i) != word.charAt(i)) {
				diff++;
				if (diff > 1) {
					return false;
				}
			}
		}
		return diff == 1;
	}
}
