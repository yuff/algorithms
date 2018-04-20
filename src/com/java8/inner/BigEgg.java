package com.java8.inner;

class Egg {
	private Yolk y;
	protected class Yolk {
		public void print() {
			System.out.println("Egg.Yolk");
		}
	}

}
public class BigEgg extends Egg{
	protected class Yolk {
		public void print() {
			System.out.println("BigEgg.Yolk");
		}
	}
	public static void main(String[] args) {
		BigEgg egg = new BigEgg();
		Egg egg1 = new BigEgg();
		egg.new Yolk().print();
		egg1.new Yolk().print(); //静态分派， output： Egg.Yolk
		((BigEgg)egg1).new Yolk().print(); //静态类型转换， output： BigEgg.Yolk
	}
}
