package com.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class DocumentFactory {

	Map<String, Document> docMap = new HashMap<>();
	
	private DocumentFactory() {
		
	}
	
	public static DocumentFactory getInstance() {
		return DocumentFactoryHolder.instance;
	}
	static class DocumentFactoryHolder {
		private static final DocumentFactory instance = new DocumentFactory();
	}
	
	public boolean addDocument(Document doc) {
		String name = doc.getName();
		if (docMap.containsKey(name)) {
			return false;
		} else {
			docMap.put(name, doc);
			return true;
		}
	}
	public Document getDocument(String name) {
		return docMap.get(name);
	}
}
