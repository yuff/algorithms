package com.leetcode.mytest;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.java8.util.TreeNode;

/**
 * 
 * Given a binary tree, return the tilt of the whole tree.
 * 
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree
 * node values and the sum of all right subtree node values. Null node has tilt 0.
 * 
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * 
 * Example: Input: 1 / \ 2 3 Output: 1 Explanation: Tilt of node 2 : 0 Tilt of node 3 : 0 Tilt of
 * node 1 : |2-3| = 1 Tilt of binary tree : 0 + 0 + 1 = 1 Note:
 * 
 * The sum of node values in any subtree won't exceed the range of 32-bit integer. All the tilt
 * values won't exceed the range of 32-bit integer.
 *
 */
public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
    	Map<TreeNode, NodeInfo> nodeMap= new HashMap<>();
    	Stack<TreeNode> stack = new Stack<>();
    	stack.add(root);
    	nodeMap.put(root, new NodeInfo(root.val));
    	TreeNode current = root;
    	while (current.left != null) {
    		stack.add(current.left);
    		current = current.left;
    	}
    	
    	while (!stack.isEmpty()) {
    		current = stack.firstElement();
			if (current.right != null) {
				current = current.right;
				stack.push(current);
				while (current.left != null) {
					stack.push(current.left);
					current = current.left;
				}
			}
    	}
		return 0;
    }
}

class NodeInfo{
	int leftSum = -1;
	int rightSum = -1;
	int nodeValue;
	public NodeInfo(int nodeValue) {
		this.nodeValue = nodeValue;
	}
}
