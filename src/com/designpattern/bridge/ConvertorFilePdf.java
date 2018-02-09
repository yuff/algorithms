package com.designpattern.bridge;

public class ConvertorFilePdf implements ConvertorFile{

	public ConvertorFilePdf(Data data) {
		System.out.println(data.getClass().getName() + " Convert to pdf");
	}
}
