package com.java8.clonetest;

import java.io.Serializable;

public class Attachment implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void download() {
		System.out.println("下载附件，文件名为" + name);
	}
}
