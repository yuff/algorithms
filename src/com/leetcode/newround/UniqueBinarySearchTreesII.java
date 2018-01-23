package com.leetcode.newround;

import java.util.*;

import com.java8.util.TreeNode;

public class UniqueBinarySearchTreesII {
	public static void main(String[] args) {
		UniqueBinarySearchTreesII ub = new UniqueBinarySearchTreesII();
		List<TreeNode> result = ub.generateTrees(10);
		System.out.println(result.size());
	}
    public List<TreeNode> generateTrees(int n) {
    	Map<String, List<TreeNode>> map = new HashMap<>();
        return generateTrees(map, 1, n);
    }
    
    private List<TreeNode> generateTrees(Map<String, List<TreeNode>> map, int start, int end) {
    	List<TreeNode> result = new ArrayList<>();
    	if (start > end) {
    		return result;
    	} else if (start == end) {
    		TreeNode node = new TreeNode(start);
    		result.add(node);
    		map.put(start + "," + end, result);
    		return result;
    	} else {
			String key = start + "," + end;
    		for(int i = start; i <=end; i++) {
    			String leftKey = start + "," + (i - 1);
    			String rightKey = (i + 1) + "," + end;
    			List<TreeNode> left = map.get(leftKey) == null? generateTrees(map, start, i - 1): map.get(leftKey);
    			List<TreeNode> right = map.get(rightKey) == null? generateTrees(map, i + 1, end): map.get(rightKey);
    			if (left.size() == 0) {
    				for(int j = 0; j < right.size(); j++) {
    					TreeNode node = new TreeNode(i);
    					node.right = right.get(j);
    					result.add(node);
    				}
    			} else if (right.size() == 0) {
    				for(int j = 0; j < left.size(); j++) {
    					TreeNode node = new TreeNode(i);
    					node.left = left.get(j);
    					result.add(node);
    				}
    			} else {
    				for(int j = 0; j< left.size(); j++) {
    					for(int k = 0; k < right.size();k++) {
    						TreeNode node = new TreeNode(i);
    						node.left = left.get(j);
    						node.right = right.get(k);
    						result.add(node);
    					}
    				}
    			}
    		}
    		map.put(key, result);
    		return result;
    	}
    }
}
