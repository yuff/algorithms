package com.leetcode.newround;

public class ValidParenthesisString {
	public static void main(String[] args) {
		ValidParenthesisString vp = new ValidParenthesisString();
		//(**((*
		System.out.println(vp.checkValidString("(((******))"));
		System.out.println(vp.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
		System.out.println(vp.checkValidString("(())(())(((()*()()()))()((()()(*()())))(((*)()"));
	}

	public boolean checkValidString(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		int n = s.length(), left = 0, star = 0, starAsLeft = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				left++;
			}
			else if (c == ')') {
				if (left > 0) {
					left--;
					if (left == 0) {
						starAsLeft += star;
						star = 0;
					}
					if (left < star) {
						starAsLeft += (star - left);
						star = left;
					}
				} else if (starAsLeft > 0) {
					starAsLeft--;
				} else if (star > 0){
					star--;
				} else {
					return false;
				}
			}
			else {
				if(left == 0) {
					starAsLeft++;
				} else {
					star++;
					if (star > left) {
						starAsLeft += (star - left);
						star = left;
					}
				}
			}
		}
		return left == 0 || left <= star;
	}
}
