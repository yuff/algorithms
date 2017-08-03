package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {
	public static void main(String[] args) {
		MinimumTimeDifference mtd = new MinimumTimeDifference();
		List<String> t = new ArrayList<>();
		t.add("05:31");
		t.add("22:08");
		t.add("00:35");
		System.out.println(mtd.findMinDifference(t));
	}
	public int findMinDifference(List<String> timePoints) {
	        if (timePoints == null || timePoints.size() < 2) {
	            return 0;
	        }
	        Collections.sort(timePoints);
	        int n = timePoints.size();
	        int result = Integer.MAX_VALUE;
	        for(int i = 1; i <= n; i ++) {
	            int tmp = distance(timePoints.get(i - 1), timePoints.get(i % n));
	            if (tmp < result){
	                result = tmp;
	            }        
	        }
	        return result;
	    }

	private int distance(String t1, String t2) {
        String[] t1s = t1.split(":");
        String[] t2s = t2.split(":");
        int h1 = Integer.valueOf(t1s[0]);
        int m1 = Integer.valueOf(t1s[1]);
        int h2 = Integer.valueOf(t2s[0]);
        int m2 = Integer.valueOf(t2s[1]);
        int mMinus = 0;
        int hMinus = 0;
        if (h2 > h1) {
            if ((h2 - h1) > 12) {
                h1 += 24;
                hMinus = h1 - h2;
                mMinus = m1 - m2;  
            } else {
                hMinus = h2 - h1;
                mMinus = m2 - m1;
            }

        } else if (h2 < h1) {
            if ((h1 - h2) > 12) {
                h2 += 24;
                hMinus = h2 - h1;
                mMinus = m2 - m1;
            } else {
                hMinus = h1 - h2;
                mMinus = m1 - m2;
            }         
        } else {
            if (m1 > m2) {
                mMinus = m1 - m2;
            } else {
                mMinus = m2 - m1;
            }
        }
        return hMinus * 60 + mMinus;
	}
}
