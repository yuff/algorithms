package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.ListNode;

public class ReverseLinkedList {
	public static void main(String[] args) {
		ReverseLinkedList rll = new ReverseLinkedList();
		int[] nums = new int[] {1, 2, 3, 4, 5, 6};
		ListNode head = CommonUtil.buildListNode(nums);
		ListNode res = rll.reverseList(head);
		while(res != null) {
			System.out.print(res.getVal());
			System.out.print(",");
			res = res.getNext();
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
        ListNode node = head;
        ListNode pre = null;
        while(node != null) {
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node= tmp;
        }
        return pre;
	}
}
