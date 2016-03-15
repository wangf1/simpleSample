package com.wangf.patterns.visitor;

import java.util.LinkedList;
import java.util.List;

public class RailWay implements IRailwayPart {

	private List<Sleeper> sleepers = new LinkedList<>();

	public void addSleeper(Sleeper sleeper) {
		sleepers.add(sleeper);
	}

	@Override
	public void accept(ITrackwalker visitor) {
		System.out.println("Railway accept Trackwalker to examine: " + visitor);
		visitor.visit(this);
		sleepers.forEach(sleeper -> {
			sleeper.accept(visitor);
		});
	}

}
