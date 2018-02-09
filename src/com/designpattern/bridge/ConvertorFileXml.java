package com.designpattern.bridge;

public class ConvertorFileXml implements ConvertorFile{

	public ConvertorFileXml(Data data) {
		System.out.println(data.getClass().getName() + " Convert to xml");
	}
}
