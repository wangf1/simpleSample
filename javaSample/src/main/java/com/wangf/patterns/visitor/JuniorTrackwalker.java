package com.wangf.patterns.visitor;

public class JuniorTrackwalker implements ITrackwalker {
	private String name;

	public JuniorTrackwalker(String name) {
		this.name = name;
	}

	@Override
	public void visit(RailWay railWay) {
		System.out.println("Junior Trackwalker track the railway: " + railWay);
	}

	@Override
	public void visit(Sleeper sleeper) {
		System.out.println("Junior Trackwalker check the sleeper: " + sleeper);
	}

	@Override
	public void visit(Bolt bolt) {
		System.out.println("Junior Trackwalker check the bolt: " + bolt);
	}

	@Override
	public String toString() {
		return "JuniorTrackwalker [name=" + name + "]";
	}

}
