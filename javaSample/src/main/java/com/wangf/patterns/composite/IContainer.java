package com.wangf.patterns.composite;

public interface IContainer extends IDisplayable {

	void add(IDisplayable label);

	void remove(IDisplayable label);

}
