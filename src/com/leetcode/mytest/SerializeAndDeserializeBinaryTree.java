package com.leetcode.mytest;

import java.util.*;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class SerializeAndDeserializeBinaryTree {
	public static void main(String[] args) {
		SerializeAndDeserializeBinaryTree sa = new SerializeAndDeserializeBinaryTree();
		TreeNode root = CommonUtil.buildTree(new Integer[] {1, 2, 3, null, null, 4, 5});
		String s = sa.serialize(root);
		System.out.println(s);
		TreeNode node = sa.deserialize(s);
		System.out.println(node.left.val);
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		int total = 1;
		while (total > 0) {
			List<TreeNode> tmp = new ArrayList<>();
			int count = 0;
			for (TreeNode node : list) {
				if (node != null) {
					builder.append(node.val);
					tmp.add(node.left);
					tmp.add(node.right);
					if (node.left != null) {
						count++;
					}
					if (node.right != null) {
						count++;
					}
				}
				else {
					builder.append("#");
				}
				builder.append(",");
			}
			total = count;
			list = tmp;
		}
		String s = builder.toString();
		return s.substring(0, s.length() - 1);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.isEmpty()) {
			return null;
		}
		String[] strs = data.split(",");
		int n = strs.length;
		if (strs.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		int id = 1;
		while (!list.isEmpty() && id < n) {
			List<TreeNode> tmp = new ArrayList<>();
			for (TreeNode node : list) {
				TreeNode left = "#".equals(strs[id]) ? null : new TreeNode(Integer.valueOf(strs[id]));
				id++;
				TreeNode right = "#".equals(strs[id]) ? null : new TreeNode(Integer.valueOf(strs[id]));
				id++;
				node.left = left;
				node.right = right;
				if (left != null) {
					tmp.add(left);
				}
				if (right != null) {
					tmp.add(right);
				}
			}
			list = tmp;
		}
		return root;
	}
}
