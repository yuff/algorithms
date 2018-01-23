package com.leetcode.mytest;

import java.util.*;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
        	return 0;
        }
        int m = triangle.size(), n = triangle.get(m - 1).size();
        int[][] min = new int[m][n];
        min[0][0] = triangle.get(0).get(0);
        int result = Integer.MAX_VALUE;
        for(int i = 1; i < m; i++) {
        	List<Integer> tmp = triangle.get(i);
        	int k = tmp.size();
        	min[i][0] = min[i - 1][0] + tmp.get(0);
        	min[i][k - 1] = min[i - 1][k-2] + tmp.get(k - 1);
        	for(int j = 1; j < k-1; j++) {
        		int a =min[i-1][j-1], b = min[i-1][j];
        		min[i][j] = Math.min(a, b) + tmp.get(j);
        		if (i == m-1 && min[i][j] < result) {
        			result = min[i][j];
        		}
        	}
        }
        return result;
    }
}
