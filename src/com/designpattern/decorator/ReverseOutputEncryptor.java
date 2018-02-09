package com.designpattern.decorator;

public class ReverseOutputEncryptor implements Encryptor {

	private Encryptor encryptor;
	public ReverseOutputEncryptor(Encryptor encryptor) {
		this.encryptor = encryptor;
	}
	@Override
	public String encrypt(String input) {
		String out = encryptor.encrypt(input);
		return reverse(out);
	}
	private String reverse(String out) {
		if (out == null || out.length() == 0) {
			return out;
		}
		char[] arr = out.toCharArray();
		for(int i = 0, j = arr.length - 1; i < j; i++, j--) {
			char tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
		return new String(arr);
	}

}
