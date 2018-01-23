package com.leetcode.newround;

import java.util.*;

public class LongestAbsoluteFilePath {
	public static void main(String[] args) {
		System.out.println("\t".length());
		LongestAbsoluteFilePath la = new LongestAbsoluteFilePath();
		System.out.println(la.lengthLongestPath("dir\n    file.txt"));
	}
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int curMax = 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        String[] strs = input.split("\n");
        map.put(0, new ArrayList<>());
        map.get(0).add(strs[0].length());
        for(int i = 1; i < strs.length; i++) {
            int level  = strs[i].lastIndexOf("\t") + 1;
            int len = strs[i].length();
            if (level == 0) {
                map.get(0).add(len);
            } else {
                List<Integer> parents = map.get(level - 1);
                int parentLen = parents.get(parents.size() - 1);
                len = parentLen + 1 + strs[i].trim().length();
                List<Integer> currentLevels = map.getOrDefault(level, new ArrayList<>());
                currentLevels.add(len);
                map.put(level, currentLevels);
            }
            curMax = Math.max(curMax, len);
        }
        return curMax;
    }
}
