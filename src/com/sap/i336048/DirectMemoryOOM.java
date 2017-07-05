//package com.sap.i336048;
//
//import java.lang.reflect.Field;
//
//import sun.misc.Unsafe;
//
///**
// * 
// * VM Args: -XX:MaxDirectMemorySize=10m
// * 
// * Exception in thread "main" java.lang.OutOfMemoryError at sun.misc.Unsafe.allocateMemory(Native
// * Method) at com.sap.i336048.DirectMemoryOOM.main(DirectMemoryOOM.java:17)
// *
// */
//public class DirectMemoryOOM {
//
//	private static final int ONE_MB = 1024 * 1024;
//
//	public static void main(String[] args) throws Exception {
//		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
//		unsafeField.setAccessible(true);
//		Unsafe unsafe = (Unsafe) unsafeField.get(null);
//		while (true) {
//			unsafe.allocateMemory(ONE_MB);
//		}
//	}
//}
