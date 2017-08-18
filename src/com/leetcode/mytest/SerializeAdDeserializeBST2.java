package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class SerializeAdDeserializeBST2 {
	public static void main(String[] args) {
		SerializeAdDeserializeBST2 sd = new SerializeAdDeserializeBST2();
		TreeNode root = CommonUtil.buildTree(new int[] {1, 2, 3});
		String s = sd.serialize(root);
		System.out.println(s);
		TreeNode t = sd.deserialize(s);
		System.out.println(t.val);
		// System.out.println(t.left.val);
		// System.out.println(t.right.val);
		// System.out.println(t.left.left.val);
		// System.out.println(t.left.right.val);
	}

	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder builder = new StringBuilder();

		builder.append(root.val);
		if (root.left != null) {
			builder.append("(");
			builder.append(serialize(root.left));
			builder.append(")");
		}
		if (root.right != null) {
			builder.append("(");
			builder.append(serialize(root.right));
			builder.append(")");
		}
		return builder.toString();
	}

	public TreeNode deserialize(String data) {
		if (data == null || data.isEmpty()) {
			return null;
		}
		return deserialize(data, 0, data.length());
	}

	private TreeNode deserialize(String data, int start, int end) {
		if (start > end) {
			return null;
		}
		int v1 = data.indexOf("(", start);
		int v2 = data.indexOf(")", start);
		int valueEnd = Math.min(v1, v2);
		int value = calValue(data, start, valueEnd > 0 ? valueEnd : end);
		TreeNode node = new TreeNode(value);
		if (valueEnd > 0) {
			int leftEnd = findEnd(data, valueEnd);
			node.left = deserialize(data, valueEnd + 1, leftEnd);
			node.right = deserialize(data, leftEnd + 2, end);
		}
		return node;
	}

	private int calValue(String data, int start, int end) {
		int value = 0;
		boolean isMinus = false;
		if (data.charAt(start) == '-') {
			isMinus = true;
			start++;
		}
		while (start < end) {
			value = (value * 10) + (data.charAt(start) - '0');
			start++;
		}
		return isMinus ? -value : value;
	}

	private int findEnd(String data, int start) {
		int n = data.length();
		int count = 1;
		for (int i = start + 1; i < n; i++) {
			if (data.charAt(i) == '(') {
				count++;
			}
			else if (data.charAt(i) == ')') {
				count--;
			}
			if (count == 0) {
				return i;
			}
		}
		return -1;
	}

}
