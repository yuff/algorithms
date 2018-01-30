package com.designpattern.simplefactory;

public class UnSupportedShapeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnSupportedShapeException() {
		super("UnSupported Shape");
	}
}
