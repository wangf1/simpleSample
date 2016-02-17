package com.wangf.patterns.composite;

public class TextInput implements IDisplayable {

	@Override
	public void display() {
		System.out.println("-------------------");
		System.out.println("| Input text here |");
		System.out.println("-------------------");
	}

}
