package com.leetcode.mytest;

public class RemoveDuplicateChar {
	public static void main(String[] args) {
		RemoveDuplicateChar rdc = new RemoveDuplicateChar();
		System.out.println(rdc.removeDuplicateLetters("bcabc"));
	}
	public String removeDuplicateLetters(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		int length = s.length();
		char[] r = removeDuplicteChars(s.toCharArray(), 0, length -1, 'a', 'z');
		return new String(r);
	}
	private char[] removeDuplicteChars(char[] charArray, int startIndex, int endIndex, char startChar, char endChar) {
		int[] arrCount = new int[26];
		boolean[] isPut = new boolean[26];
		int resultLen = 0;
		for(int i = startIndex; i <= endIndex; i++) {
			int index = charArray[i] - 'a';
			if (arrCount[index] == 0) {
				resultLen++;
			}
			arrCount[index]++;
		}
		char[] result = new char[resultLen];
		int[] resultIndex = new int[resultLen];
		int rIndex = 0;
		for(int i = startIndex; i <= endIndex; i++) {
			char c = charArray[i];
			int index = c - 'a';
			if (c - startChar < 0 || endChar - c < 0) {
				arrCount[index]--;
			} else {
				if (arrCount[index] > 1) {
					boolean isRemove = false;
					int startCharIndex = startChar - 'a';
					for(int k = startCharIndex; k < index; k++) {
						if (!isPut[k] && arrCount[k] > 0) {
							isRemove = true;
							break;
						}
					}
					if (isRemove) {
						arrCount[index]--;
					} else {
						result[rIndex] = c;
						resultIndex[rIndex] = i;
						startChar = c;
					}
				} else if (arrCount[index] == 1) {
					int recurStartIndex = 0;
					char recurStartChar = 'a';
					char recurEndChar = (char)(c - 1);
					
					boolean isRemove = false;
					int startCharIndex = startChar - 'a';
					for(int k = startCharIndex; k < index; k++) {
						if (!isPut[k] && arrCount[k] > 0) {
							isRemove = true;
							break;
						}
					}
					if (isRemove) {
						if (rIndex > 0) {
							recurStartIndex = resultIndex[rIndex - 1];
							recurStartChar = result[rIndex - 1];
						}
						char[] tmpResult = removeDuplicteChars(charArray, recurStartIndex, i-1, recurStartChar, recurEndChar);
						for(char t: tmpResult) {
							result[rIndex++] = t;
						}
					} else {
						startChar = c;
						result[rIndex] = c;
						resultIndex[rIndex] = i;
						rIndex++;
					}
					

				}
			}
		}
		return result;
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
