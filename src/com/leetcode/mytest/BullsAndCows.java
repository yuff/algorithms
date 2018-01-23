package com.leetcode.mytest;

public class BullsAndCows {
	public static void main(String[] args) {
		BullsAndCows bac = new BullsAndCows();
		System.out.println(bac.getHint("1807", "7810"));
	}
    public String getHint(String secret, String guess) {
        if (guess == null || guess.isEmpty()) {
        	return "0A0B";
        }
        int m = secret.length(), n = guess.length(), a = 0, b = 0;
        int[] sArr = new int[10], gArr = new int[10];
        for(int i = 0; i < m; i++) {
        	char s = secret.charAt(i);
        	if (i < n) {
        		char g = guess.charAt(i);
        		if (g == s) {
        			a++;
        		} else {
        			sArr[s - '0'] += 1;
        			gArr[g - '0'] += 1;
        		}
        	} else {
        		sArr[s - '0'] += 1;
        	}
        }
        for(int i = m; i < n; i++) {
        	char g = guess.charAt(i);
        	gArr[g - '0'] += 1;
        } 
        for(int i = 0; i < 10; i++) {
        	b += Math.min(sArr[i], gArr[i]);
        }
        StringBuilder r = new StringBuilder();
        r.append(a);
        r.append("A");
        r.append(b);
        r.append("B");
        return r.toString();
    }
}
