package com.wangf.patterns.builder;

public class SUVBuilder implements IBuilder {

	private ICar car = new SUV();

	@Override
	public void buildEngine() {
		car.setEngine("4.6 V8");
	}

	@Override
	public void buildOtherParts() {
		car.setOtherParts("Other parts for a SUV...");
	}

	@Override
	public ICar construct() {
		return car;
	}

}
