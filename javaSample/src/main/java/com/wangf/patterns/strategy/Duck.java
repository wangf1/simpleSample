package com.wangf.patterns.strategy;

public class Duck {
	private IFlyStrategy flyBehavior;

	public void setFlyStrategy(IFlyStrategy flyStrategy) {
		flyBehavior = flyStrategy;
	}

	public void fly() {
		flyBehavior.fly();
	}
}
