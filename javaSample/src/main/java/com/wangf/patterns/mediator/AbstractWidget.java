package com.wangf.patterns.mediator;

public class AbstractWidget {
	protected IMediator mediator;

	public AbstractWidget(IMediator mediator) {
		this.mediator = mediator;
		mediator.addWidget(this);
	}
}
