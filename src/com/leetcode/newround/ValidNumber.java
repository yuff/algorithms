package com.leetcode.newround;

public class ValidNumber {

	public static void main(String[] args) {
		String numRegex = "^(([+,-]?\\d+\\.?\\d*)|([+,-]?\\d*\\.?\\d+))$";
		String eRegex = "^([+,-]?((\\d*\\.?\\d+)|(\\d+\\.?\\d*))[eE][+-]?\\d+)$";
		
		
		System.out.println("111e+111".matches(eRegex));
		System.out.println(".111e-111".matches(eRegex));
		System.out.println("1.e1".matches(eRegex));
		System.out.println("111,111".matches(numRegex));
		System.out.println("3.".matches(numRegex));
		System.out.println(".3".matches(numRegex));
		System.out.println(".".matches(numRegex));
		System.out.println("3".matches(numRegex));
//		System.out.println(".1".matches(numRegex));
//		System.out.println("1.1".matches(numRegex));
//		System.out.println("00.1".matches(numRegex));
		ValidNumber vn = new ValidNumber();
//		System.out.println(vn.isValid("-1111"));
//		System.out.println(vn.isValid("111.3334"));
//		System.out.println(vn.isValid("111.3334e11.12"));
//		System.out.println(vn.isValid(".1e3334"));
//		System.out.println(vn.isValid("3.123"));
//		System.out.println(vn.isValid("3.123,123"));
	}
	public boolean isValid(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		String t = s.trim();
		String numRegex = "^[+,-]?((\\d*)?\\.?\\d*)$";
		
		String eRegex = "^[+,-]?\\d*\\.?\\d*(\\d[E,e][+,-]?\\d*)?\\d$";
		return t.matches(eRegex);
	}
}
