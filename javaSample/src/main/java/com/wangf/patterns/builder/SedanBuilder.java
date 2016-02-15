package com.wangf.patterns.builder;

public class SedanBuilder implements IBuilder {

	private ICar car = new Sedan();

	@Override
	public void buildEngine() {
		car.setEngine("2.0 Turbo");
	}

	@Override
	public void buildOtherParts() {
		car.setOtherParts("Other parts for a sedan...");
	}

	@Override
	public ICar construct() {
		return car;
	}

}
