package com.wangf.patterns.composite;

public class Client {
	public static void main(String[] args) {
		IContainer form = new Form();
		IDisplayable label = new Label("Hello: ");
		label.display();
		form.add(label);

		IDisplayable textInput = new TextInput();
		textInput.display();
		form.add(textInput);
		form.display();

		form.remove(label);
		form.display();
	}
}
