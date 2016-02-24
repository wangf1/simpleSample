package com.wangf.patterns.mediator;

public class Label extends AbstractWidget {

	public Label(IMediator mediator) {
		super(mediator);
	}

	public void setText(String string) {
		System.out.println("Label changed: " + string);
	}

}
