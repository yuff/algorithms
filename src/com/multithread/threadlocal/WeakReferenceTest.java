package com.multithread.threadlocal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * gc: -Xmx10m
 *
 */
public class WeakReferenceTest {

	public static void main(String[] args) {
		Car car = new Car("BMW");
		WeakReference<Car> weakCar = new WeakReference<>(car);
		if (weakCar.get() != null) {
			System.out.println(weakCar.get().getName());
		}
		Map<String, Integer> map = new HashMap<>();
		map.put(null, 10);
		System.out.println(map.get(null));
		
//		Map<String, Integer> table = new ConcurrentHashMap<>();
//		table.put(null, 10);
//		System.out.println(table.get(null));
		
		SequenceNumber sn = new SequenceNumber();
		NoteBooks nb = new NoteBooks();
		TestClient tc1 = new TestClient(sn, nb);
		tc1.start();
		
		List<Object> list = new ArrayList<>();
		for (int i = 0; i < 300000; i++) {
			Car helloBean1 = new Car("test");
			list.add(helloBean1);
		}

		if (weakCar.get() != null) {
			System.out.println(weakCar.get().getName());
		}
		else {
			System.out.println("Object has been collected");
		}
	}

}
