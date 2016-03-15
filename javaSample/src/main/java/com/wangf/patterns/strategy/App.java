package com.wangf.patterns.strategy;

public class App {
	public static void main(String[] args) {
		Duck rubberDuck = new Duck();
		IFlyStrategy flyNoWay = new FlyNoWay();
		rubberDuck.setFlyStrategy(flyNoWay);
		rubberDuck.fly();

		Duck rocketDuck = new Duck();
		rocketDuck.setFlyStrategy(new FlyWithRocket());
		rocketDuck.fly();

		Duck realWildDuck = new Duck();
		realWildDuck.setFlyStrategy(new FlyWithWing());
		realWildDuck.fly();
	}
}
