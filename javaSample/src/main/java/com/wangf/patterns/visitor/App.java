package com.wangf.patterns.visitor;

public class App {
	public static void main(String[] args) {
		RailWay railWay = new RailWay();

		Sleeper sleeper = new Sleeper();
		sleeper.addBolt(new Bolt());
		sleeper.addBolt(new Bolt());
		railWay.addSleeper(sleeper);

		Sleeper sleeper2 = new Sleeper();
		sleeper2.addBolt(new Bolt());
		sleeper2.addBolt(new Bolt());
		railWay.addSleeper(sleeper2);

		System.out.println("-------------JuniorTrackwalker start work----------------");
		ITrackwalker junior = new JuniorTrackwalker("Jerry");
		railWay.accept(junior);
		System.out.println("-------------SeniorTrackwalker start work----------------");
		ITrackwalker senior = new SeniorTrackwalker("Tom");
		railWay.accept(senior);
	}
}
