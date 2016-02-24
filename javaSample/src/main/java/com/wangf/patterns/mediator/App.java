package com.wangf.patterns.mediator;

public class App {
	public static void main(String[] args) {
		IMediator mediator = new Mediator();
		Combobox combobox = new Combobox(mediator);
		new Label(mediator);
		Button button = new Button(mediator);
		// When combobox selection changed, mediator will notify label and
		// button
		combobox.setSelectIndex(2);
		button.click();
	}

}
