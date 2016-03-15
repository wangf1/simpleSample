package com.wangf.patterns.visitor;

public interface IRailwayPart {
	void accept(ITrackwalker visitor);
}
