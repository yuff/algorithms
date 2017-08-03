package com.leetcode.mytest;

public class FriendCircles {

	public static void main(String[] args) {
		int[][] M = new int[4][4];
		M[0] = new int[]{1,0,0,1};
		M[1] = new int[]{0,1,1,0};
		M[2] = new int[]{0,1,1,1};
		M[3] = new int[]{1,0,1,1};
		FriendCircles fc = new FriendCircles();
		System.out.println(fc.findCircleNum(M));
	}
	public int findCircleNum(int[][] M) {
		if(M == null || M.length == 0) {
			return 0;
		}
		int num = M.length;
		int result = 0;
		boolean[] count = new boolean[num];
		for(int i = 0; i < num; i++) {
			if (!count[i]) {
				visitFriend(M,count, i);
				result++;
			}
		}
		return result;
	}
	
	private void visitFriend(int[][] M, boolean[] count, int i) {
		int num = M.length;
		count[i] = true;
		for(int j = 0; j < num; j++) {
			if(M[i][j] == 1 && !count[j]) {
				visitFriend(M, count, j);
			}
		}
	}
}
