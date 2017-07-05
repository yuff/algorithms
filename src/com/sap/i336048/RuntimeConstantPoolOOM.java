package com.sap.i336048;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * VM Args：-XX：PermSize=10M-XX：MaxPermSize=10M JDK1.6 and previous version will get 
 * Exception in 
 * thread"main"java.lang.OutOfMemoryError：PermGen space at java.lang.String.intern（Native Method）
 * JDK7 and after version will not get this exception
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
//		List<String> list = new ArrayList<String>();
//		int i = 0;
//		while (true) {
//			list.add(String.valueOf(i++).intern());
//			System.out.println(list.get(i - 1));
//		}
		String str1 = new StringBuilder("Hello").append(" World").toString();
		System.out.println(str1.intern() == str1); //true
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2); //false
		
		String str3 = new StringBuilder("Hello").append(" World").toString();
		System.out.println(str3.intern() == str3); //false
	}
}
