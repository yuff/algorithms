package com.leetcode.newround;

public class OneBitAndTwoBitCharacters {
	public static void main(String[] args) {
		OneBitAndTwoBitCharacters ob = new OneBitAndTwoBitCharacters();
		int[] bits = new int[]{1,0,1,1,0};
		System.out.println(ob.isOneBitCharacter(bits));
	}
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
        	return false;
        }
        int n = bits.length;
        if (bits[n - 1] == '1') {
        	return false;
        }
        boolean[] isOneOrTwo = new boolean[n + 1];
        isOneOrTwo[0] = true;
        isOneOrTwo[1] = bits[0] == 0;
        for(int i = 2; i <= n; i++) {
        	switch(bits[i - 1]) {
        		case 0:
        			isOneOrTwo[i] = isOneOrTwo[i - 1] || isOneOrTwo[i - 2];
        			break;
        		case 1:
        			isOneOrTwo[i] = !isOneOrTwo[i - 1] && isOneOrTwo[i - 2];
        			break;
        	}
        }
        return isOneOrTwo[n - 1];
    }
}
