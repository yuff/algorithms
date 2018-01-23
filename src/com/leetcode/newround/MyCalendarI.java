package com.leetcode.newround;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyCalendarI {
    List<int[]> books;

	public MyCalendarI() {
        books = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if (books.size() == 0) {
            books.add(new int[]{start, end});
            return true;
        }
        Collections.sort(books, new Comparator<int[]>(){
           @Override
            public int compare(int[] o1, int[]o2) {
                return o1[1] - o2[1];
            }
        });
        for(int[] book: books) {
            if (end < book[1] && end > book[0]) {
                return false;
            } else if (end == book[1]) {
                return false;
            } else if (end > book[1] && start >= book[0] && start < book[1]){
                return false;
            }
        }
        books.add(new int[]{start, end});
        return true;
    }
}
