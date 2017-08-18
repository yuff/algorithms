package com.leetcode.mytest;

import java.util.LinkedList;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class SerializeAdDeserializeBST {
	public static void main(String[] args) {
		SerializeAdDeserializeBST sd = new SerializeAdDeserializeBST();
		TreeNode root = CommonUtil.buildTree(new int[] {1, 2, 3, 4, 5});
		String s = sd.serialize(root);
		System.out.println(s);
		TreeNode t = sd.deserialize(s);
		System.out.println(t.val);
		System.out.println(t.left.val);
		System.out.println(t.right.val);
		System.out.println(t.left.left.val);
		System.out.println(t.left.right.val);
	}

	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		LinkedList<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);
		int count = 1;
		boolean hasNotNull = true;
		while (hasNotNull) {
			hasNotNull = false;
			int tmp = count;
			while(tmp > 0) {
				TreeNode n = nodes.poll();
				if (n == null) {
					nodes.add(null);
					nodes.add(null);
					builder.append(",");
				}
				else {
					nodes.add(n.left);
					nodes.add(n.right);
					builder.append(n.val);
					builder.append(",");
					if (!hasNotNull && (n.left != null || n.right != null)) {
						hasNotNull = true;
					}
				}
				tmp--;
			}
			count *= 2;
		}
		return builder.toString();
	}

	public TreeNode deserialize(String data) {
		if (data == null || data.isEmpty()) {
			return null;
		}
		String[] strs = data.split(",");
		return buildTree(strs, 0);
	}

	private TreeNode buildTree(String[] strs, int i) {
		if (strs == null || strs.length <= i || strs[i] == null || strs[i].isEmpty()) {
			return null;
		}
		int n = strs.length;
		TreeNode node = new TreeNode(Integer.valueOf(strs[i]));
		if (n > 2 * i + 1) {
			node.left = buildTree(strs, 2 * i + 1);
		}
		if (n > 2 * i + 2) {
			node.right = buildTree(strs, 2 * i + 2);
		}
		return node;
	}
}
