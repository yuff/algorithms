package com.designpattern.decorator;

public class ModeEncryptor implements Encryptor {

	private Encryptor encryptor;
	public ModeEncryptor(Encryptor encryptor) {
		this.encryptor = encryptor;
	}
	@Override
	public String encrypt(String input) {
		String out = encryptor.encrypt(input);
		return mode(out);
	}

	private String mode(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			char c = arr[i];
			arr[i]  = (char) (c % 7);
		}
		return new String(arr);
	}
}
