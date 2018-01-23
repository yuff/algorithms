package com.leetcode.newround;

import java.util.*;

import com.java8.util.CommonUtil;

public class RedundantConnection {
	public static void main(String[] args) {
		RedundantConnection rc = new RedundantConnection();
		int[][] edges = new int[10][2];
		edges[0] = new int[]{3,7};
		edges[1] = new int[]{1,4};
		edges[2] = new int[]{2,8};
		edges[3] = new int[]{1,6};
		edges[4] = new int[]{7,9};
		edges[5] = new int[]{6,10};
		edges[6] = new int[]{1,7};
		edges[7] = new int[]{2,3};
		edges[8] = new int[]{8,9};
		edges[9] = new int[]{5,9};
		int[] result = rc.findRedundantConnection(edges );
		CommonUtil.print(result);
	}
	public int[] findRedundantConnection(int[][] edges) {
		if (edges == null || edges.length == 0) {
			return new int[0];
		}
		Map<Integer, Node> map = new HashMap<>();
		for (int[] edge : edges) {
			int e1 = edge[0], e2 = edge[1];
			if (map.get(e1) == null && map.get(e2) == null) {
				Node node1 = new Node(e1);
				node1.parent = node1;
				node1.children = new ArrayList<>();
				map.put(e1, node1);
				Node node2 = new Node(e2, node1);
				map.put(e2, node2);
			}
			else if (map.get(e1) != null && map.get(e2) != null) {
				Node root1 = map.get(e1).parent;
				Node root2 = map.get(e2).parent;
				if (root1 == root2) {
					return edge;
				}
				else {
					merge(root1, root2);
				}
			}
			else {
				if (map.get(e1) == null) {
					Node node1 = new Node(e1, map.get(e2).parent);
					map.put(e1, node1);
				}
				else {
					Node node2 = new Node(e2, map.get(e1).parent);
					map.put(e2, node2);
				}
			}
		}
		return new int[0];
	}

	private void merge(Node root1, Node root2) {
		root2.setParent(root1);
		List<Node> children = root2.children;
		for (Node child : children) {
			child.setParent(root1);
		}
	}
}

class Node {
	Node(int value) {
		this.value = value;
	}

	Node(int value, Node parent) {
		this.value = value;
		this.parent = parent;
		if (this.parent.children == null) {
			this.parent.children = new ArrayList<>();
		}
		this.parent.children.add(this);
	}

	Node parent;
	int value;
	List<Node> children;
	
	void setParent(Node parent) {
		this.parent = parent;
		parent.children.add(this);
	}
}
