package com.wangf.patterns.builder;

public interface IBuilder {
	void buildEngine();

	void buildOtherParts();

	ICar construct();
}
