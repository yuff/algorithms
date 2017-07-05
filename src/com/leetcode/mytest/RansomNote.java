package com.leetcode.mytest;

public class RansomNote {

	public static void main(String[] args) {
		RansomNote note = new RansomNote();
		String ransomNote = "aa";
		String magazine = "aab";
		System.out.println(note.canConstruct(ransomNote, magazine));
	}
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] mArray = magazine.toCharArray();
        int[] mNumArray = new int[26];
        for(char c: mArray) {
            int index = c - 97;
            mNumArray[index]++;
        }
        char[] rArray = ransomNote.toCharArray();
        for (char c: rArray) {
            int index = c - 97;
            if (mNumArray[index] > 0) {
                mNumArray[index]--;
            } else {
                return false;
            }
        }
        return true;
    }
}
