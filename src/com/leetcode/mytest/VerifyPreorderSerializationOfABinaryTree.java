package com.leetcode.mytest;

import java.util.LinkedList;

public class VerifyPreorderSerializationOfABinaryTree {
	public static void main(String[] args) {
		VerifyPreorderSerializationOfABinaryTree vp = new VerifyPreorderSerializationOfABinaryTree();
		System.out.println(vp.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		System.out.println(vp.isValidSerialization("1,#"));
		System.out.println(vp.isValidSerialization("9,#,#,1"));
	}
	public boolean isValidSerialization(String preorder) {
		if (preorder == null || preorder.isEmpty()) {
			return true;
		}
		String[] strs = preorder.split(",");
		int n = strs.length;
		LinkedList<String> left = new LinkedList<>();
		LinkedList<String> right = new LinkedList<>();
		if (!"#".equals(strs[0])) {
			left.add(strs[0]);
		}
		for (int i = 1; i < n; i++) {
			if (left.isEmpty() && right.isEmpty()) {
				return false;
			}
			if (!left.isEmpty()) {
				String s = left.pop();
				right.push(s);
			}
			else {
				right.pop();
			}
			String cur = strs[i];
			if (!"#".equals(cur)) {
				left.push(cur);
			}
		}
		return left.isEmpty() && right.isEmpty();
	}
}
