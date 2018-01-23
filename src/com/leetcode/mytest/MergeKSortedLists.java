package com.leetcode.mytest;

import com.java8.util.ListNode;

public class MergeKSortedLists {
	public static void main(String[] args) {
		MergeKSortedLists mkl = new MergeKSortedLists();
		ListNode[] lists = new ListNode[4];
		lists[1] = new ListNode(-1);
		lists[1].next = new ListNode(5);
		lists[1].next.next = new ListNode(11);
		lists[3] = new ListNode(6);
		lists[3].next = new ListNode(10);
		
		ListNode result = mkl.mergeKLists(lists);
		while(result != null) {
			System.out.print(result.val);
			System.out.print(",");
			result = result.next;
		}
	}
	 public ListNode mergeKLists(ListNode[] lists) {
	        if (lists == null || lists.length == 0) {
	            return null;
	        }
	        buildMinfyHeap(lists);
	        ListNode result = null;
	        ListNode cur = null;
	        while(lists[0] != null) {
	            if (result == null) {
	                result = lists[0];
	                cur = result;
	            } else {
	                cur.next = lists[0];
	                cur = cur.next;
	            }
	            lists[0] = lists[0].next;
	            minfyHeap(lists, 0);
	        }
	        return result;
	    }
	    
	    private void buildMinfyHeap(ListNode[] lists) {
	        int len = lists.length;
	        for(int i = len - 1; i >=0; i--) {
	            minfyHeap(lists, i);
	        }
	    }
	    
	    private void minfyHeap(ListNode[] lists, int index) {
	        int left = (index + 1) << 1 - 1;
	        int right = (index + 1) << 1;
	        int min = index;
	        int length = lists.length;
	        if (left < length && lists[left] != null && ( lists[min] == null || lists[left].val < lists[min].val)) {
	            min = left;
	        }
	        if (right < length && lists[right] != null && (lists[min] == null || lists[right].val < lists[min].val)) {
	            min = right;
	        }
	        if (min != index) {
	            ListNode tmp = lists[index];
	            lists[index] = lists[min];
	            lists[min] = tmp;
	            minfyHeap(lists, min);
	        }
	    }
}
