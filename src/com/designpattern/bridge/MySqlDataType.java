package com.designpattern.bridge;

public class MySqlDataType implements DataType {

	@Override
	public Data loadData() {
		return new MySqlData("mysql");
	}

}
