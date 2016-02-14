package com.wangf.patterns.abstractfactory;

public class OnpremiseFactory implements IFactory {

	@Override
	public IProduct1 createProduct1() {
		return new Product1Onpremise();
	}

	@Override
	public IProduct2 createProduct2(Product2Type type) {
		if (type == Product2Type.GOOD_PRODUCT2) {
			return new Product2OnpremiseGood();
		} else {
			return new Product2OnpremiseBetter();
		}
	}

}
