package com.leetcode.newround;

import java.util.*;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class SerializeAndDeserializeBST {
	public static void main(String[] args) {
		SerializeAndDeserializeBST sad = new SerializeAndDeserializeBST();
		TreeNode root = CommonUtil.buildTree(new Integer[] {1, 2,null, 3, 4, null, null, 5, 6});
		CommonUtil.print(root);
		String s = sad.serialize(root);
		System.out.println("after serialize:" + s);
		TreeNode result = sad.deserialize(s);
		System.out.println("tree build by string:");
		CommonUtil.print(result);
	}

	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		List<TreeNode> list = new ArrayList<>();

		list.add(root);
		while (!list.isEmpty()) {
			List<TreeNode> tmp = new ArrayList<>();
			int nullCount = 0;
			for (TreeNode node : list) {
				if (node == null) {
					sb.append("#,");
				}
				else {
					sb.append(node.val);
					sb.append(",");
					tmp.add(node.left);
					tmp.add(node.right);
					nullCount += node.left == null ? 1 : 0;
					nullCount += node.right == null ? 1 : 0;
				}
			}
			list = nullCount == tmp.size() ? new ArrayList<>() : tmp;
		}
		return sb.substring(0, sb.length() - 1);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.isEmpty()) {
			return null;
		}
		String[] strs = data.split(",");
		TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
		int n = strs.length;
		List<TreeNode> curNodes = new ArrayList<>();
		curNodes.add(root);
		int i = 1;
		while (i < n) {
			List<TreeNode> tmp = new ArrayList<>();
			for (int j = 0; j < curNodes.size(); j++) {
				TreeNode node = curNodes.get(j);
				TreeNode left = null, right = null;
				if (i <= n - 1) {
					String next = strs[i++];
					if (!"#".equals(next)) {
						left = new TreeNode(Integer.valueOf(next));
						tmp.add(left);
					}
				}
				if (i <= n - 1) {
					String next = strs[i++];
					if (!"#".equals(next)) {
						right = new TreeNode(Integer.valueOf(next));
						tmp.add(right);
					}
				}
				node.left = left;
				node.right = right;
				if (i == n) {
					break;
				}
			}
			curNodes = tmp;
		}
		return root;
	}
}
