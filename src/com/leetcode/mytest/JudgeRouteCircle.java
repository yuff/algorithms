package com.leetcode.mytest;

public class JudgeRouteCircle {
	public static void main(String[] args) {
		JudgeRouteCircle jr = new JudgeRouteCircle();
		System.out.println(jr.judgeCircle("UD"));
		System.out.println(jr.judgeCircle("LL"));
	}
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.isEmpty()) {
        	return true;
        }
        int x = 0, y = 0, n = moves.length(), i = 0;
        while (i < n) {
        	char c = moves.charAt(i);
//        	switch(c) {
//        		case 'L':
//        			x--;
//        			break;
//        		case 'R':
//        			x++;
//        			break;
//        		case 'U':
//        			y++;
//        			break;
//        		case 'D':
//        			y--;
//        			break;
//        	}
        	if (c == 'L') {
        		x--;
        	} else if (c == 'R') {
        		x++;
        	} else if (c == 'U') {
        		y++;
        	} else if (c == 'D') {
        		y--;
        	}
        	i++;
        }
        return x== 0 && y == 0;
    }
}
