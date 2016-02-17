package com.wangf.patterns.decorator;

public class TextView implements IDisplayable {

	private String text;

	public TextView(String text) {
		this.text = text;
	}

	@Override
	public void display() {
		System.out.println(text);
	}

}
