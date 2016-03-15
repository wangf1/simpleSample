package com.wangf.patterns.templatemethod;

public class JsonRequestProcessor extends AbstractRequestProcessor {

	@Override
	protected ImportantBusinessObject marshalRequestToBusinessObject(String request) {
		System.out.println("Pretend build the ImportantBusinessObject from a JSON request.");
		ImportantBusinessObject businessObject = new ImportantBusinessObject();
		businessObject.setValue(request);
		return businessObject;
	}

}
