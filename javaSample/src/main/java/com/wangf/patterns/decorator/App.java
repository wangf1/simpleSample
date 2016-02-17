package com.wangf.patterns.decorator;

public class App {
	public static void main(String[] args) {
		IDisplayable withoutDecrator = new TextView("The text in text view");
		withoutDecrator.display();
		IDisplayable withDecorator = new Border(withoutDecrator);
		withDecorator.display();
	}
}
