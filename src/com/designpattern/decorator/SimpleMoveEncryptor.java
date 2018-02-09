package com.designpattern.decorator;

public class SimpleMoveEncryptor implements Encryptor {

	@Override
	public String encrypt(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}
		char[] arr = input.toCharArray();
		char tmp = arr[0];
		for(int i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[arr.length - 1] = tmp;
		return new String(arr);
	}

}
