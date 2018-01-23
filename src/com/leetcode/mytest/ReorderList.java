package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.ListNode;

public class ReorderList {
	public static void main(String[] args) {
		ReorderList rl = new ReorderList();
		ListNode head = CommonUtil.buildListNode(new int[] {1, 2, 3, 4});
		rl.reorderList(head);
		CommonUtil.print(head);
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode mid = findMid(head);
		ListNode reverseHead = mid.next;
		mid.next = null;
		reverseHead = reverse(reverseHead);
		merge(head, reverseHead);
	}

	private void merge(ListNode head, ListNode reverseHead) {
		ListNode f = head, s = reverseHead;
		while (f != null && s != null) {
			ListNode tmp = f.next;
			ListNode stmp = s.next;
			f.next = s;
			s.next = tmp;
			f = tmp;
			s = stmp;
		}
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head, cur = head.next, next = cur.next;
		pre.next = null;
		while (next != null) {
			cur.next = pre;
			pre = cur;
			cur = next;
			next = next.next;
		}
		cur.next = pre;
		return cur;
	}

	private ListNode findMid(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
