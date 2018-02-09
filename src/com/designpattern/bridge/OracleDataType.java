package com.designpattern.bridge;

public class OracleDataType implements DataType {

	@Override
	public Data loadData() {
		return new OracleData("oracle");
	}

}
