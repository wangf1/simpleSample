package com.wangf.patterns.visitor;

public interface ITrackwalker {
	void visit(RailWay railWay);

	void visit(Sleeper sleeper);

	void visit(Bolt bolt);
}
