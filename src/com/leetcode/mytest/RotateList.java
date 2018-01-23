package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.ListNode;

public class RotateList {
	public static void main(String[] args) {
		RotateList rl = new RotateList();
		ListNode head = CommonUtil.buildListNode(new int[] {1, 2, 3});
		ListNode node = rl.rotateRight(head, 1);
		CommonUtil.print(node);
		ListNode node1 = rl.rotateRight(node, 1);
		CommonUtil.print(node1);
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		ListNode first = head, second = head;
		int len = 1; 
		int tmp = k;
		while (tmp > 0 && second.next != null) {
			second = second.next;
			len++;
			tmp--;
		}
		if (tmp > 0) {
			k = k % len;
			second = head;
			while (k > 0) {
				second = second.next;
				k--;
			}
		}
		if (first == second) {
			return head;
		}
		while (second.next != null) {
			first = first.next;
			second = second.next;
		}
		ListNode newHead = first.next;
		first.next = null;
		second.next = head;
		return newHead;
	}
}
