package com.wangf.patterns.templatemethod;

public abstract class AbstractRequestProcessor {

	public void process(String request) {
		System.out.println("Pretend to do some validation or other common tasks.");
		System.out.println("Pretend extract the inputstream from request: " + request);
		ImportantBusinessObject businessObject = marshalRequestToBusinessObject(request);
		System.out.println("Pretend do some buiness logic against the business object: " + businessObject);
	}

	/**
	 * This is the template method, it is a step of a algorithm
	 * 
	 * @param request
	 * @return
	 */
	protected abstract ImportantBusinessObject marshalRequestToBusinessObject(String request);

}
