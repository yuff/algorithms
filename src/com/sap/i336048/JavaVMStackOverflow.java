package com.sap.i336048;
/**
 * VM Args: -Xss128k
 * @author I336048
 *
 */
public class JavaVMStackOverflow {

	private int stackLength = 1;
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	public static void main(String[] args) throws Throwable {
		JavaVMStackOverflow oom = new JavaVMStackOverflow();
		try {
			oom.stackLeak();
		} catch(Throwable e) {
			System.out.println("stack length:"  + oom.stackLength + "\n");
			throw e;
		}
	}
}
