package com.wangf.patterns.mediator;

public interface IMediator {

	void widgetChanged(AbstractWidget widget);

	void addWidget(AbstractWidget widget);

}