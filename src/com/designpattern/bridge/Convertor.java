package com.designpattern.bridge;

public abstract class Convertor {
	DataType dataType;

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public ConvertorFile convert() {
		if (dataType == null) {
			throw new RuntimeException("Please set data type first");
		}
		Data data = dataType.loadData();
		return convertToFile(data);
	}

	public abstract ConvertorFile convertToFile(Data data);
}
