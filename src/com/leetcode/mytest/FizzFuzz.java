package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Write a program that outputs the string representation of numbers from 1 to n.
 * 
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of
 * five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 */
public class FizzFuzz {

	public List<String> fizzBuzz(int n) {
		String fizz = "Fizz";
		String buzz = "Buzz";
		String fizzBuzz = "FizzBuzz";
		List<String> result = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				result.add(fizzBuzz);
			} else if (i %3 == 0) {
				result.add(fizz);
			} else if (i % 5 == 0) {
				result.add(buzz);
			} else {
				result.add(i + "");
			}
		}
		return result;
	}
}
