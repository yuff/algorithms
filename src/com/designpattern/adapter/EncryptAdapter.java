package com.designpattern.adapter;

public class EncryptAdapter implements EncryptInterface {
	 private ThirdPartEncrypt thirdPartEncrypt;
	
	public EncryptAdapter(ThirdPartEncrypt thirdPartEncrypt) {
		this.thirdPartEncrypt = thirdPartEncrypt;
	}
	@Override
	public String encrypt(String str) {
		return thirdPartEncrypt.tpEncrypt(str);
	}

	@Override
	public String decrypt(String str) {
		return thirdPartEncrypt.tpDecrypt(str);
	}

}
