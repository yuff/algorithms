package com.leetcode.mytest;

import java.util.LinkedList;

import com.java8.util.TreeNode;

public class KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
    	if (root == null || k < 1) {
    		throw new RuntimeException("error input");
    	}
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while(node != null) {
        	stack.add(node);
        	node = node.left;
        }
        TreeNode r = root;
        while(k > 0) {
        	if (stack.isEmpty()) {
        		throw new RuntimeException("input k is bigger than total element number");
        	}
        	r = stack.pollLast();
        	k--;
        	node = r.right;
        	while(node != null) {
        		stack.add(node);
        		node = node.left;
        	}
        }
        return r.val;
    }
}
