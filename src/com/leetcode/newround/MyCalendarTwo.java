package com.leetcode.newround;

import java.util.*;

public class MyCalendarTwo {
	public static void main(String[] args) {
		MyCalendarTwo mc = new MyCalendarTwo();
		System.out.println(mc.book(47,50));
		System.out.println(mc.book(1,10));
		System.out.println(mc.book(27,36));
		System.out.println(mc.book(40,47));
		System.out.println(mc.book(20,27));
		System.out.println(mc.book(15,23));
		System.out.println(mc.book(10,18));
		System.out.println(mc.book(27,36));
		System.out.println(mc.book(47,50));
		System.out.println(mc.book(2,7));
		System.out.println(mc.book(6,13));
	}

	List<int[]> books;
	List<int[]> twices;

	public MyCalendarTwo() {
		books = new ArrayList<>();
		twices = new ArrayList<>();
	}

	public boolean book(int start, int end) {
		if (books.size() == 0) {
			books.add(new int[] {start, end});
			return true;
		}
		for (int[] book : twices) {
			if ((book[1] > start && book[1] <= end) || (book[0] >= start && book[0] < end)) {
				return false;
			}
		}
		List<int[]> tmp = new ArrayList<>();
		for (int[] book : books) {
			if (end > book[0] && end <= book[1]) {
				tmp.add(new int[] {Math.max(book[0], start), Math.min(end, book[1])});
			}
			else if (start >= book[0] && start < book[1]) {
				tmp.add(new int[] {Math.max(book[0], start), Math.min(end, book[1])});
			} else if (start <= book[0] && end >= book[1]) {
				tmp.add(new int[] {Math.max(book[0], start), Math.min(end, book[1])});
			}
		}
		twices.addAll(tmp);
		books.add(new int[] {start, end});
		return true;
	}
}
