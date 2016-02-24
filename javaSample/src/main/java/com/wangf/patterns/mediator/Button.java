package com.wangf.patterns.mediator;

public class Button extends AbstractWidget {

	public Button(IMediator mediator) {
		super(mediator);
	}

	public void setEnabled(boolean enable) {
		System.out.println("Button enable status changed: " + enable);
	}

	public void click() {
		mediator.widgetChanged(this);
	}

}
