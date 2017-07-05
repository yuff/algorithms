package com.leetcode.mytest;

import java.util.Stack;

public class MergeTrees {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.right = new TreeNode(2);
		t1.left.left = new TreeNode(5);
		
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(3);
		t2.left.right = new TreeNode(4);
		t2.right.right = new TreeNode(7);
		TreeNode t = new MergeTrees().mergeTrees(t1, t2);
		System.out.println(t.val);
	}
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}
		t1.val = t1.val + t2.val;
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(t1);
		stack2.push(t2);
		while (!stack1.isEmpty()) {
			TreeNode tn1 = stack1.pop();
			TreeNode tn2 = stack2.pop();
			
			if (tn1.right == null) {
				tn1.right = tn2.right;
			}
			else if (tn1.right != null) {
				tn1.right.val = tn1.right.val + tn2.right.val;
				stack1.push(tn1.right);
				stack2.push(tn2.right);
			}
			if (tn1.left != null && tn2.left != null) {
				tn1.left.val = tn1.left.val + tn2.left.val;
				stack1.push(tn1.left);
				stack2.push(tn2.left);
			}
			else if (tn1.left == null) {
				tn1.left = tn2.left;
			}
		}
		return t1;
	}
}
