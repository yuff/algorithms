package com.leetcode.newround;

import java.math.BigInteger;
import java.util.*;

import com.java8.util.CommonUtil;
import com.java8.util.TreeNode;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.BNK(1234567, 36));
		TreeNode T = CommonUtil.buildTree(new int[]{4,5,6,4,4,1,6,5,6,7,8,9});
		System.out.println(t.BST(T));
	}
	
	public int BST(TreeNode T){
		LinkedList<TreeNode> stack = new LinkedList<>();
		int n = findMaxVal(T), curCount = 0, max = 0;
		int[] counts = new int[n + 1];
		Map<TreeNode, Boolean> visit = new HashMap<>();
		TreeNode cur = T;
		while (cur != null) {
			stack.push(cur);
			counts[cur.val]++;
			if (counts[cur.val] == 1) {
				curCount++;
			}
			cur = cur.left;
		}
		while(!stack.isEmpty()) {
			TreeNode p = stack.peek();
			if (visit.get(p) == null && p.right != null) {
				visit.put(p, true);
				cur = p.right;
				while (cur != null) {
					stack.push(cur);
					counts[cur.val]++;
					if (counts[cur.val] == 1) {
						curCount++;
					}
					cur = cur.left;
				}
			} else {
				if (p.right == null) {					
					max = Math.max(max, curCount);
				}
				stack.pop();
				counts[p.val]--;
				if (counts[p.val] == 0) {
					curCount--;
				}
			}
		}
		return max;
	}
	
	private int findMaxVal(TreeNode t) {
		int result = 0;
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode cur = t;
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result = Math.max(node.val, result);
			cur = node.right;
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
		}
		return result;
	}

	public int BNK(int N, int K) {
		int min = Math.min(K, N-K), n = N;
		BigInteger result = BigInteger.valueOf(1);
		while (min > 0) {
			result = result.multiply(BigInteger.valueOf(n));
			n--;
			min--;
		}
		min = Math.min(K, N-K);
		while (min > 0) {
			result = result.divide(BigInteger.valueOf(min));
			min--;
		}
		return result.compareTo(BigInteger.valueOf(1000000000)) > 0? -1: result.intValue();
	}
}
