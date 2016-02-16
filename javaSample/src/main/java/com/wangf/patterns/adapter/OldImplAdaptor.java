package com.wangf.patterns.adapter;

public class OldImplAdaptor implements INewAPI {
	private OldImpl impl;

	public OldImplAdaptor() {
		this.impl = new OldImpl();
	}

	@Override
	public void newMethod() {
		// suppose the old method implementation meet the requirement
		impl.oldMethod();
	}

}
