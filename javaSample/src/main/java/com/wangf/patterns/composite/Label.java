package com.wangf.patterns.composite;

public class Label implements IDisplayable {

	private String text;

	public Label(String text) {
		this.text = text;
	}

	@Override
	public void display() {
		text = text == null ? "" : text;
		System.out.println(text);
	}

}
