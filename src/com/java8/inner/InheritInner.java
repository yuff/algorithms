package com.java8.inner;

public class InheritInner extends WithInner.Inner {
	public InheritInner(WithInner wi) {
		wi.super();
	}
}
