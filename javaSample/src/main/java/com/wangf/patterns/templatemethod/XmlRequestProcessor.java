package com.wangf.patterns.templatemethod;

public class XmlRequestProcessor extends AbstractRequestProcessor {

	@Override
	protected ImportantBusinessObject marshalRequestToBusinessObject(String request) {
		System.out.println("Pretend build the ImportantBusinessObject from a XML request.");
		ImportantBusinessObject businessObject = new ImportantBusinessObject();
		businessObject.setValue(request);
		return businessObject;
	}

}
