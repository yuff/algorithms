package com.designpattern.bridge;

public class BridgeMain {

	public static void main(String[] args) {
		DataType mysql = new MySqlDataType();
		Convertor pdf = new PdfConvertor();
		pdf.setDataType(mysql);
		pdf.convert();
		
		DataType oracle = new OracleDataType();
		pdf.setDataType(oracle);
		pdf.convert();
		
		Convertor xml = new XmlConvertor();
		xml.setDataType(mysql);
		xml.convert();
	}
}
