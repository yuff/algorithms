package com.sap.i336048;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * VM Args: -XX:MaxMetaspaceSize=10m -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 *
 *
 * exception: Exception in thread "main" net.sf.cglib.core.CodeGenerationException:
 * java.lang.reflect.InvocationTargetException-->null at
 * net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:237) at
 * net.sf.cglib.proxy.Enhancer.createHelper(Enhancer.java:377) at
 * net.sf.cglib.proxy.Enhancer.create(Enhancer.java:285) at
 * com.sap.i336048.JavaMethodAreaOOM.main(JavaMethodAreaOOM.java:27) Caused by:
 * java.lang.reflect.InvocationTargetException at
 * sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source) at
 * sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) at
 * java.lang.reflect.Method.invoke(Method.java:498) at
 * net.sf.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:384) at
 * net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:219) ... 3 more
 * Caused by: java.lang.OutOfMemoryError: Metaspace at java.lang.ClassLoader.defineClass1(Native
 * Method) at java.lang.ClassLoader.defineClass(ClassLoader.java:763) ... 8 more
 */
public class JavaMethodAreaOOM {

	public static void main(String[] args) {
		int i = 0;
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {

				@Override
				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					return proxy.invoke(obj, args);
				}

			});
			OOMObject obj = (OOMObject) enhancer.create();
			// System.out.println(i++);
			// obj.sayHello(i + "");

		}
	}

	static class OOMObject {
		private List<String> list = new ArrayList<>(1000);
		private List<Double> dList = new ArrayList<>(1000);
		private List<Float> fList = new ArrayList<>(1000);

		public void sayHello(String hello) {
			System.out.println("hello world," + hello);
		}
	}
}
