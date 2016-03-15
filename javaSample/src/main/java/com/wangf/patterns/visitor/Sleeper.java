package com.wangf.patterns.visitor;

import java.util.ArrayList;
import java.util.List;

public class Sleeper implements IRailwayPart {

	private List<Bolt> bolts = new ArrayList<>();

	public void addBolt(Bolt bolt) {
		bolts.add(bolt);
	}

	@Override
	public void accept(ITrackwalker visitor) {
		System.out.println("Sleeper accept trackwalker to examine: " + visitor);
		visitor.visit(this);
		bolts.forEach(bolt -> bolt.accept(visitor));
	}

}
