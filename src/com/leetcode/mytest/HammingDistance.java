package com.leetcode.mytest;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding
 * bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note: 0 ≤ x, y < 231.
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation: 1 (0 0 0 1) 4 (0 1 0 0) ↑ ↑
 * 
 * The above arrows point to positions where the corresponding bits are different.
 *
 */
public class HammingDistance {
	public static void main(String[] args) {
		System.out.println(hammingDistance(1,2));
	}
    public static int hammingDistance(int x, int y) {
        int xy = x ^ y;
        int i = 0;
        while (xy != 0) {
            if ((xy & 1) == 1) {
                i++;
            }
            xy = xy >> 1;
        }
        return i;
    }
}
