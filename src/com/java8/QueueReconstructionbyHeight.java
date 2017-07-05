package com.java8;

import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionbyHeight {

	public static void main(String[] args) {
		int[][] arr = new int[6][2];
		arr[0] = new int[] {7, 0};
		arr[1] = new int[] {4, 4};
		arr[2] = new int[] {7, 1};
		arr[3] = new int[] {5, 0};
		arr[4] = new int[] {6, 1};
		arr[5] = new int[] {5, 2};
		int[][] result = new QueueReconstructionbyHeight().reconstructQueue(arr);
		System.out.println(result[1][1]);
	}

	public int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length == 0) {
			return people;
		}
		Arrays.parallelSort(people, new Comparator<int[]>() {
			public int compare(int[] t1, int[] t2) {
				if (t1[0] > t2[0]) {
					return -1;
				}
				else if (t1[0] == t2[0]) {
					if (t1[1] > t2[1]) {
						return 1;
					}
					else if (t1[1] < t2[1]) {
						return -1;
					}
					else {
						return 0;
					}
				}
				else {
					return 1;
				}
			}
		});
		Node root = null;
		for (int[] p : people) {
			root = insertInNode(root, p);
		}
		int row = people.length;
		int[][] result = new int[row][2];
		Node node = root;
		int i = 0;
		while (node != null) {
			result[i++] = node.val;
			node = node.next;
		}
		return result;
	}

	private Node insertInNode(Node node, int[] p) {
		int num = p[1];
		Node newNode = new Node(p);
		if (node == null) {
			return newNode;
		}
		if (num == 0) {
			newNode.next = node;
			return newNode;
		}
		Node cur = node;
		while (num > 1) {
			cur = cur.next;
			num--;
		}
		newNode.next = cur.next;
		cur.next = newNode;
		return node;
	}
}

class Node {
	int[] val;
	Node next;

	Node(int[] val) {
		this.val = val;
	}
}
