package com.wangf.patterns.strategy;

public class FlyWithRocket implements IFlyStrategy {

	@Override
	public void fly() {
		System.out.println("Fly with rocket!");
	}

}
