package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextGreaterElementIII {
	public static void main(String[] args) {
		NextGreaterElementIII ng = new NextGreaterElementIII();
		System.out.println(ng.nextGreaterElement(1999999999));
	}
    public int nextGreaterElement(int n) {
        if (n < 10) {
        	return -1;
        }
        List<Integer> bits = new ArrayList<>();
        while (n > 0) {
        	bits.add(n % 10);
        	n /= 10;
        }
        int len = bits.size();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
        	arr[len - 1 - i] = bits.get(i);
        }
        int[] id = findLastAscId(arr); 
        if (id[0] == -1) {
        	return -1;
        }
        switchArr(arr, id[0], id[1]);
        Arrays.sort(arr, id[0] + 1, len);
        int result = 0;
        for(int i = 0; i < len; i++) {
        	long r = (long)result * 10;
        	if (r != (int)r) {
        		return -1;
        	}
        	result = (int)r + arr[i];
        	if (((result ^ r) & (result ^ arr[i])) < 0) {
        		return -1;
        	}
        }
        return result;
    }
	private void switchArr(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	private int[] findLastAscId(int[] arr) {
		int n = arr.length;
		int[] result = new int[2];
		Arrays.fill(result, -1);
		int pre = n - 1, cur = n - 2;
		while (cur >= 0) {
			if (arr[pre] > arr[cur]) {
				result[0] = cur;
				for(int i = n - 1; i >= pre; i--) {
					if (arr[i] > arr[cur]) {
						result[1] = i;
						break;
					}
				}
				break;
			} else {
				pre = cur;
				cur--;
			}
		}
		return result;
	}
}
