package com.leetcode.mytest;

import java.util.LinkedList;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class SubtreeOfAnotherTree {
	public static void main(String[] args) {
		SubtreeOfAnotherTree soat = new SubtreeOfAnotherTree();
		TreeNode s = CommonUtil.buildTree(new int[] {3, 4, 5, 1, 2});
		TreeNode t = CommonUtil.buildTree(new int[] {4, 1, 2});
		System.out.println(soat.isSubtree(s, t));
	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null || t == null) {
			return false;
		}
		LinkedList<TreeNode> sameStack = new LinkedList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.push(s);
		while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			if (tmp.val == t.val) {
				sameStack.push(tmp);
			}
			if (tmp.left != null) {
				stack.push(tmp.left);
			}
			if (tmp.right != null) {
				stack.push(tmp.right);
			}
		}
		boolean isSame = false;
		while (!sameStack.isEmpty()) {
			TreeNode same = sameStack.pop();
			if (isSameTree(same, t)) {
				isSame = true;
				break;
			}
		}
		return isSame;
	}

	private boolean isSameTree(TreeNode s, TreeNode t) {
		LinkedList<TreeNode> sStack = new LinkedList<>();
		LinkedList<TreeNode> tStack = new LinkedList<>();
		sStack.push(s);
		tStack.push(t);
		while (!sStack.isEmpty() && !tStack.isEmpty()) {
			TreeNode sTmp = sStack.pop();
			TreeNode tTmp = tStack.pop();
			if (sTmp == null && tTmp == null) {
				continue;
			}
			else if (sTmp == null) {
				return false;
			}
			else if (tTmp == null) {
				return false;
			}
			else {
				if (sTmp.val != tTmp.val) {
					return false;
				}
				else {
					sStack.push(sTmp.left);
					sStack.push(sTmp.right);
					tStack.push(tTmp.left);
					tStack.push(tTmp.right);
				}
			}
		}
		return true;
	}
}
