package com.interview;

import com.java8.util.TreeNode;

public class BstDistance {

	public static void main(String[] args) {
		BstDistance bd = new BstDistance();
		int[] values = new int[]{7,5,6,3,1,2,4,9,12,10,11};
		System.out.println(bd.bstDistance(values , 2, 11));
	}
	public int bstDistance(int[] values,int node1, int node2) {
		TreeNode root = buildBST(values);
		TreeNode cur = root;
		int min = Math.min(node1, node2), max = Math.max(node1, node2);
		while (!(cur.val >= min && cur.val <= max)) {
			if (cur.val < min) {
				cur = cur.right;
			}
			else {
				cur = cur.left;
			}
		}
		return distance(cur, min) + distance(cur, max);
	}

	private int distance(TreeNode node, int value) {
		if (node.val == value) {
			return 0;
		}
		else if (node.val > value) {
			return 1 + distance(node.left, value);
		}
		else {
			return 1 + distance(node.right, value);
		}
	}

	private TreeNode buildBST(int[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		int n = values.length;
		TreeNode root = new TreeNode(values[0]);
		for(int i = 1; i < n; i++) {
			addToTree(root, values[i]);
		}
		return root;
	}

	private void addToTree(TreeNode root, int value) {
		TreeNode cur = root, pre = null;
		while (cur != null) {			
			pre = cur;
			if (cur.val > value) {
				cur = cur.left;
			} else {
				cur = cur.right; 
			}
		}
		if (value > pre.val) {
			pre.right = new TreeNode(value);
		} else {
			pre.left = new TreeNode(value);
		}
	}
}
