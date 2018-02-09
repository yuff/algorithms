package com.designpattern.bridge;

public class TxtConvertor extends Convertor {

	@Override
	public ConvertorFile convertToFile(Data data) {
		return new ConvertorFileTxt(data);
	}

}
