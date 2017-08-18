package com.java8.holdingobject;

class Snow {
	static String s = "Snow";
	static {
		System.out.println("snow init");
	}
	Snow() {
		System.out.println("snow constructor");
	}
}

class Powder extends Snow {
	static String p = "Powder";
	static {
		System.out.println("powder init");
	}
	Powder() {
		System.out.println("powder constructor");
	}
}

class Light extends Powder {

}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}

public class AsListInference {

	public static void main(String[] args) {
		String s = Powder.p;
//		List<Snow> snow1 = Arrays.asList(new Crusty(), new Powder(), new Light());
//		List<Powder> snow2 = Arrays.asList(new Light(), new Heavy());
	}
}
