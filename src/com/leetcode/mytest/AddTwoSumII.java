package com.leetcode.mytest;

import com.java8.util.ListNode;

public class AddTwoSumII {
	public static void main(String[] args) {
		AddTwoSumII at = new AddTwoSumII();
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next.next.next.next = new ListNode(9);

		ListNode l2 = new ListNode(7);
		ListNode r = at.addTwoNumbers(l1, l2);
		System.out.println(r.val);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		long l1Value = 0;
		long l2Value = 0;
		ListNode node = l1;
		while (node != null) {
			l1Value = (l1Value * 10) + node.val;
			node = node.next;
		}
		node = l2;
		while (node != null) {
			l2Value = (l2Value * 10) + node.val;
			node = node.next;
		}
		long value = (long) l1Value + (long) l2Value;
		ListNode result = null;
		while (value != 0) {
			ListNode l = new ListNode((int) (value % 10));
			value = value / 10;
			l.next = result;
			result = l;
		}
		if (result == null) {
			result = new ListNode(0);
		}
		return result;
	}
}
