package com.interview;

import java.util.*;

public class ConvertExpressionToReversePolishNotation {
	public static void main(String[] args) {
		ConvertExpressionToReversePolishNotation ce = new ConvertExpressionToReversePolishNotation();
		System.out.println(ce.convertToRPN(new String[] {"12", "+", "5", "*", "(","33", "+", "45", "*", "21", "+",
		                                                 "11",")", "*", "22", "/", "7"}));
	}

	public List<String> convertToRPN(String[] expression) {
		List<String> result = new ArrayList<>();
		if (expression == null || expression.length == 0) {
			return result;
		}
		LinkedList<Operation> stack = new LinkedList<>();
		for (String e : expression) {
			if (Operation.getOperation(e) != null) {
				Operation curOper = Operation.getOperation(e);
				if (stack.isEmpty()) {
					stack.push(Operation.Left.equals(curOper)? Operation.Right: curOper);
				}
				else {
					while (!stack.isEmpty() && stack.peek().value >= curOper.value) {
						Operation o = stack.pop();
						if (!Operation.Right.equals(o)) {							
							result.add(o.operation);
						} else {
							break;
						}
					}
					if (!Operation.Right.equals(curOper)) {						
						stack.push(Operation.Left.equals(curOper)? Operation.Right: curOper);
					}
				}
			}
			else {
				result.add(e);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek().value > 0) {
				result.add(stack.pop().operation);
			}
		}
		return result;
	}
}

enum Operation {
				Add("+", 1), Minus("-", 1), Multiply("*", 2), Div("/", 2), Left("(",3), Right(")",0);

	int value;
	String operation;

	Operation(String operation, int value) {
		this.value = value;
		this.operation = operation;
	}

	static Operation getOperation(String s) {
		switch (s) {
			case "+":
				return Add;
			case "-":
				return Minus;
			case "*":
				return Multiply;
			case "/":
				return Div;
			case "(":
				return Left;
			case ")":
				return Right;
		}
		return null;
	}
}
