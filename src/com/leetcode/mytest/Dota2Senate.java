package com.leetcode.mytest;

import java.util.*;

public class Dota2Senate {
	public static void main(String[] args) {
		Dota2Senate ds = new Dota2Senate();
		System.out.println(ds.predictPartyVictory("DRRD"));
		System.out.println(ds.predictPartyVictory("DDRRR"));
		System.out.println(ds.predictPartyVictory("DRDRR"));
	}

	public String predictPartyVictory(String senate) {
		if (senate == null || senate.isEmpty()) {
			return "";
		}
		int len = senate.length();
		List<Integer> rList = new ArrayList<>(), dList = new ArrayList<>();
		for (int i = len - 1; i >= 0; i--) {
			char c = senate.charAt(i);
			if (c == 'D') {
				dList.add(i);
			}
			else {
				rList.add(i);
			}
		}
		if (rList.isEmpty()) {
			return "Dire";
		}
		else if (dList.isEmpty()) {
			return "Radiant";
		}
		int rCount = rList.size(), dCount = dList.size();
		while (rCount > 0 && dCount > 0) {
			int m = rCount - 1, n = dCount - 1;
			int i = m, j = n;
			while (i >= 0 && j >= 0) {
				int rId = rList.get(i), dId = dList.get(j);
				if (rId < dId) {
					dList.remove(j);
					dCount--;
				}
				else {
					rList.remove(i);
					rCount--;
				}
				i--;
				j--;
			}
			while (i >= 0) {
				if (dCount <= i + 1) {
					return "Radiant";
				}
				else {
					dList.remove(dCount - 1);
					dCount--;
					i--;
				}
			}
			while (j >= 0) {
				if (rCount <= j+1) {
					return "Dire";
				}
				else {
					rList.remove(rCount - 1);
					rCount--;
					j--;
				}
			}
		}
		return rCount > 0 ? "Radiant" : "Dire";

	}
}
