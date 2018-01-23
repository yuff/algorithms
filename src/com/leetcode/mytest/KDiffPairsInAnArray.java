package com.leetcode.mytest;

import java.util.*;

public class KDiffPairsInAnArray {
	public static void main(String[] args) {
		KDiffPairsInAnArray kd = new KDiffPairsInAnArray();
		int[] nums = new int[]{1,3,1,5,4};
		System.out.println(kd.findPairs(nums , 0));
	}
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums) {
            if (map.get(num) == null) {
                map.put(num,1);
            } else {
                int c = map.get(num);
                if (k == 0 && c == 1) {
                    count++;
                }
                map.put(num, c + 1);
            }
        }
//        if (k == 0) {
//            return count;
//        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int i = 0, j = 1, n = list.size();
        while (i < n && j < n) {
            int m = list.get(j) - list.get(i);
            if ( m == k) {
                count++;
                i++;
                j++;
            } else if (m < k) {
                j++;
            } else {
                i++;
                if (i == j) {
                	j++;
                }
            }
        }
        return count;
    }
}
