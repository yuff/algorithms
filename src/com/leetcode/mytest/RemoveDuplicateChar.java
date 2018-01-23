package com.leetcode.mytest;

import java.util.*;

public class RemoveDuplicateChar {
	public static void main(String[] args) {
		RemoveDuplicateChar rdc = new RemoveDuplicateChar();
		System.out.println(rdc.removeDuplicateLetters("bcabc"));
	}
	 public String removeDuplicateLetters(String s) {
		 if (s == null || s.isEmpty()) {
			 return s;
		 }
		 List<Integer>[] arr = new List[26];
		 for(int i = 0; i < 26; i++) {
			 arr[i] = new ArrayList<>();
		 }
		 int n = s.length();
		 for(int i = 0; i < n; i++) {
			 char c = s.charAt(i);
			 int id = c - 'a';
			 arr[id].add(i);
		 }
		 int[][] res = new int[26][2];
		 int id = 0;
		 for(int i = 0; i < 26; i++) {
			 if (arr[i].size() > 0) {
				 res[id][0] = i;
				 res[id][1] = findId(res, i);
				 id++;
			 }
		 }
		 Arrays.sort(res, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}			 
		 });
		 return null;
	 }
	private int findId(int[][] res, int i) {
		// TODO Auto-generated method stub
		return 0;
	}
	
//    public String removeDuplicateLetters(String s) {
//        if ( s == null || s.isEmpty()) {
//            return s;
//        }
//        int[] arr = new int[26];
//        char[] cArray = s.toCharArray();
//        int len = 0;
//        for(char c: cArray) {
//            int index = c - 'a';
//            if (arr[index] == 0) {
//                len++;
//            }
//            arr[index]++;
//        }
//        return new String(findLexiResult(cArray, arr, len));
//    }
//    private char[] removeDuplicatedChar(char[] cArray, int start, int end) {
//    	int[] arr = new int[26];
//    	int len = 0;
//    	for(int i = start; i <=end; i++) {
//            int index = cArray[i] - 'a';
//            if (arr[index] == 0) {
//                len++;
//            }
//            arr[index]++;
//    	}
//    }
//	private char[] findLexiResult(char[] cArray, int[] arrCount, int len) {
//		int arrayLen = cArray.length;
//		int[] removeCount = new int[arrayLen];
//		boolean[] isPut = new boolean[26];
//		int[] resultIndex = new int[len];
//		char[] result = new char[len];
//		int curIndex = 0;
//		for(int i = 0; i < arrayLen; i++) {
//			int m = cArray[i] - 'a';
//			if (arrCount[m] == 1) {
//				curIndex = fillPreviousChar(cArray, i, curIndex, isPut, result, resultIndex, removeCount);
//				result[curIndex] = cArray[i];
//				resultIndex[curIndex] = i;
//				curIndex++;
//			} else {
//				boolean remove = false;
//				for(int j = 0; j < m; j++) {
//					if (arrCount[j] !=0 && !isPut[j]) {
//						remove = true;
//					}
//				}
//				if (remove) {
//					arrCount[i]--;
//					removeCount[i]++;
//				}
//			}
//
//		}
//		return null;
//	}
//	private int fillPreviousChar(char[] cArray, int end, int curIndex, boolean[] isPut, char[] result, int[] resultIndex, int[] removeCount) {
//		int start = 0;
//		if (curIndex > 0) {
//			start = resultIndex[curIndex - 1];
//		}
//		return 0;
//	}
}
