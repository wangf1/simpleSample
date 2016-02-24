package com.wangf.patterns.mediator;

public class Combobox extends AbstractWidget {

	private int selectIndex;

	public Combobox(IMediator mediator) {
		super(mediator);
	}

	public void setSelectIndex(int i) {
		selectIndex = i;
		mediator.widgetChanged(this);
	}

	public int getSelectIndex() {
		return selectIndex;
	}

}
