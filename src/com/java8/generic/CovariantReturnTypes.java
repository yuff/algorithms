package com.java8.generic;

class Base {
}

class Derived extends Base {
}

class OrdinaryGetter {
	Base get() {
		System.out.println("OrdinaryGetter --- get");
		return new Base();
	}
}

class OrdinarySetter {
	void set(Base base) {
		System.out.println("OrdinarySetter.set(Base)");
	}
}

class DerivedSetter extends OrdinarySetter {
	void set(Derived base) {
		System.out.println("DerivedSetter.set(Derived)");
	}
}

class DerivedGetter extends OrdinaryGetter {
	Derived get() {
		System.out.println("DerivedGetter --- get");
		return new Derived();
	}
}

public class CovariantReturnTypes {

	public static void main(String[] args) {
		DerivedGetter dg = new DerivedGetter();
		dg.get();
		
		DerivedSetter ds = new DerivedSetter();
		ds.set(new Base());
		ds.set(new Derived());
	}
}
