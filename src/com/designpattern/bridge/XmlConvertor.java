package com.designpattern.bridge;

public class XmlConvertor extends Convertor {

	@Override
	public ConvertorFile convertToFile(Data data) {
		return new ConvertorFileXml(data);
	}

}
