package com.interview;

import java.util.*;

public class ForwardBackwordDistance {

	public static void main(String[] args) {
		ForwardBackwordDistance fb = new ForwardBackwordDistance();
		char[] steps = new char[]{'A','A','A','R','A','R','R','R','A','A','A','A','A','A','R','R','R'};
		int distance = fb.disctaneMove(steps);
		System.out.println(distance);
		System.out.println(fb.printSteps(steps.length, distance));
		System.out.println(fb.printSteps(5, 2));
	}
	public int disctaneMove(char[] steps) {
		if (steps == null || steps.length == 0) {
			return 0;
		}
		int forwordV = 1, backwordV = 1, distance = 0;
		for(int i = 0; i < steps.length; i++) {
			char c = steps[i];
			if (c == 'A') {
				distance += forwordV;
				forwordV *= 2;
				backwordV = 1;
			} else if (c == 'R') {
				distance -= backwordV;
				backwordV *= 2;
				forwordV = 1;
			}
		}
		return distance;
	}
	
	public List<List<String>> printSteps(int n, int distance) {
		if (n == 0) {
			return new ArrayList<>();
		}
		List<List<String>> result = new ArrayList<>();
		List<String> tmp = new ArrayList<>();
		printSteps(result, tmp, 1, 1, 0, n, distance);
		return result;
	}

	private void printSteps(List<List<String>> result, List<String> tmp, int forwardV, int backwordV, int curDistance, int n, int distance) {
		if (tmp.size() == n) {
			if (curDistance == distance) {
				result.add(new ArrayList<>(tmp));				
			}
			return;
		}
		tmp.add("A");
		printSteps(result, tmp, forwardV * 2, 1, curDistance + forwardV, n, distance);
		tmp.remove(tmp.size() - 1);
		tmp.add("R");
		printSteps(result, tmp, 1, backwordV * 2, curDistance - backwordV, n, distance);
		tmp.remove(tmp.size() - 1);
	}
}
