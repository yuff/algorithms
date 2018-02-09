package com.leetcode.newround;

import java.util.*;

public class ReachANumber {
	public static void main(String[] args) {
		ReachANumber ra = new ReachANumber();
		System.out.println(ra.reachNumber(2));
		System.out.println(ra.reachNumber(3));
		System.out.println(ra.reachNumber(-1000000000));
	}
    public int reachNumber(int target) {
        if (target == 0) {
        	return 0;
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int step = 1;
        while (true) {
        	Set<Integer> next = nextSteps(set, step);
        	if (next.contains(target)) {
        		break;
        	} else {
        		set = next;
        		step++;
        	}
        }
        return step;
    }

	private Set<Integer> nextSteps(Set<Integer> set, int step) {
		Set<Integer> curSet = new HashSet<>(set);
		while (step > 0) {
			Set<Integer> tmp = new HashSet<>();
			Iterator<Integer> iter = curSet.iterator();
			while(iter.hasNext()) {
				int val = iter.next();
				tmp.add(val + 1);
				tmp.add(val - 1);
			}
			curSet = tmp;
			step--;
		}
		return curSet;
	}
}
