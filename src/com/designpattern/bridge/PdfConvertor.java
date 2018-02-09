package com.designpattern.bridge;

public class PdfConvertor extends Convertor {

	@Override
	public ConvertorFile convertToFile(Data data) {
		return new ConvertorFilePdf(data);
	}

}
