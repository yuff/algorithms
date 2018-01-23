package com.leetcode.mytest;

import com.java8.util.ListNode;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		OddEvenLinkedList oe = new OddEvenLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode node = oe.oddEvenList(head);
		while(node != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
	}
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode cur = head, end = head;
		int size = 1;
		while(end.next != null) {
			size++;
			end = end.next;
		}
		if (size < 3) {
			return head;
		}
		size = size >> 1;
		int index = 0;
		while(index < size) {
			ListNode tmp = cur.next;
			ListNode third = tmp.next;
			tmp.next = null;
			cur.next = third;
			end.next = tmp;
			end = end.next;
			cur = cur.next;
			index++;
		}
		return head;
	}
	public ListNode oddEvenList1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode odd, even, oddCur, evenCur, cur;
		odd = head;
		oddCur = odd;
		even = head.next;
		evenCur = even;
		cur = even.next;
		int i = 1;
		while(cur != null) {
			ListNode tmp = cur.next;
			if (i % 2 == 0) {
				evenCur.next = cur;
				evenCur = evenCur.next;
				evenCur.next = null;
			} else {
				oddCur.next = cur;
				oddCur = oddCur.next;
				oddCur.next = null;
			}
			cur = tmp;
			i++;
		}
		oddCur.next = even;
		return odd;
	}
}
