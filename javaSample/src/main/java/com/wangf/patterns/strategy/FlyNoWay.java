package com.wangf.patterns.strategy;

public class FlyNoWay implements IFlyStrategy {

	@Override
	public void fly() {
		System.out.println("I cannot fly.");
	}

}
