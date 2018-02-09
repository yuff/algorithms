package com.designpattern.decorator;

import static org.junit.Assert.*;

import org.junit.Test;

public class EncryptorTest {

	@Test
	public void testSimpleMoveEncryptor() {
		Encryptor sme = new SimpleMoveEncryptor();
		assertEquals("bcdefa",sme.encrypt("abcdef"));
	}
	
	@Test
	public void testReverseOutputEncryptor() {
		Encryptor sme = new SimpleMoveEncryptor();
		Encryptor roe = new ReverseOutputEncryptor(sme);
		assertEquals("afedcb", roe.encrypt("abcdef"));
	}
	
	@Test public void testModeEncryptor() {
		Encryptor sme = new SimpleMoveEncryptor();
		Encryptor roe = new ReverseOutputEncryptor(sme);
		Encryptor me = new ModeEncryptor(roe);
		System.out.println(me.encrypt("abcdef"));
	}
}
