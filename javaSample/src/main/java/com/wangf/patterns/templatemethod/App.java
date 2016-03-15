package com.wangf.patterns.templatemethod;

public class App {
	public static void main(String[] args) {

		System.out.println("---------Process a JSON request----------");
		AbstractRequestProcessor jsonProcessor = new JsonRequestProcessor();
		jsonProcessor.process("JSON_Request");

		System.out.println("---------Process a XML request----------");
		AbstractRequestProcessor xmlProcessor = new XmlRequestProcessor();
		xmlProcessor.process("XML_Request");
	}
}
