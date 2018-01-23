package com.leetcode.mytest;

import com.java8.util.CommonUtil;
import com.java8.util.ListNode;
public class PartitionList {
	public static void main(String[] args) {
		PartitionList pl = new PartitionList();
		ListNode head = CommonUtil.buildListNode(new int[] {1, 4, 3, 2, 5, 2});
		ListNode node = pl.partition(head, 3);
		while (node != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
	}

	public ListNode partition(ListNode head, int x) {
		ListNode less = null, lcur = null, greater = null, gcur = null, cur = head;
		while (cur != null) {
			if (cur.val < x) {
				if (less == null) {
					less = cur;
					lcur = less;
				}
				else {
					lcur.next = cur;
					lcur = lcur.next;
				}
			}
			else {
				if (greater == null) {
					greater = cur;
					gcur = greater;
				}
				else {
					gcur.next = cur;
					gcur = gcur.next;
				}
			}
			cur = cur.next;
			if (lcur != null) {				
				lcur.next = null;
			}
			if (gcur != null) {				
				gcur.next = null;
			}
		}
        if (lcur != null) {
            lcur.next = greater;
            return less;
        } else {
            return greater;
        }  
	}
}
