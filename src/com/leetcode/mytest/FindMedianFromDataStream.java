package com.leetcode.mytest;

import java.util.*;

public class FindMedianFromDataStream {

	public static void main(String[] args) {
		FindMedianFromDataStream mf = new FindMedianFromDataStream();
		mf.addNum(6);
		System.out.println(mf.findMedian());
		mf.addNum(10);
		System.out.println(mf.findMedian());
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(6);
		System.out.println(mf.findMedian());
		mf.addNum(5);
		mf.addNum(0);
		mf.addNum(6);
		mf.addNum(3);
		mf.addNum(1);
		mf.addNum(0);
		mf.addNum(0);
		System.out.println(mf.findMedian());
		
	}
	PriorityQueue<Integer> smallest = new PriorityQueue<>();
	PriorityQueue<Integer> largest = new PriorityQueue<>(Collections.reverseOrder());
	

	/** initialize your data structure here. */
    public FindMedianFromDataStream() {
    }

    public void addNum(int num) {
    	largest.add(num);
    	smallest.add(largest.poll());
    	if (largest.size() < smallest.size()) {
    		largest.add(smallest.poll());
    	}
    }
    
    public double findMedian() {
        if (largest.size() == smallest.size()) {
        	return (largest.peek() + smallest.peek()) / 2.0;
        } else {
        	return largest.peek();
        }
    }
}
