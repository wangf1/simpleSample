package com.wangf.patterns.visitor;

public class SeniorTrackwalker implements ITrackwalker {
	private String name;

	public SeniorTrackwalker(String name) {
		this.name = name;
	}

	@Override
	public void visit(RailWay railWay) {
		System.out.println("Senior Trackwalker track the railway: " + railWay);
	}

	@Override
	public void visit(Sleeper sleeper) {
		System.out.println("Senior Trackwalker check and fix the sleeper: " + sleeper);
	}

	@Override
	public void visit(Bolt bolt) {
		System.out.println("Senior Trackwalker check and fix the bolt: " + bolt);
	}

	@Override
	public String toString() {
		return "SeniorTrackwalker [name=" + name + "]";
	}

}
