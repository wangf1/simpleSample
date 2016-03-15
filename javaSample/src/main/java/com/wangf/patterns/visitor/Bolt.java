package com.wangf.patterns.visitor;

public class Bolt implements IRailwayPart {

	@Override
	public void accept(ITrackwalker visitor) {
		System.out.println("Bolt accept trackwalker to examine: " + visitor);
		visitor.visit(this);
	}

}
