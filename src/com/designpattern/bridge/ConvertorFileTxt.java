package com.designpattern.bridge;

public class ConvertorFileTxt implements ConvertorFile {

	public ConvertorFileTxt(Data data) {
		System.out.println(data.getClass().getName() + " Convert to txt");
	}
}
