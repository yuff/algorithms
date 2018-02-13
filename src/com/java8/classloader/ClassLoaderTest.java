package com.java8.classloader;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

	public static void main(String[] args) {
		ClassLoader myLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass("java.lang.String", b, 0, b.length);
				}
				catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};

		try {
			Object obj = myLoader.loadClass("com.java8.classloader.ClassLoaderTest");
			System.out.println(obj.getClass());
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
