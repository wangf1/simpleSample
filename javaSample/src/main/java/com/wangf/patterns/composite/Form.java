package com.wangf.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Form implements IContainer {

	private List<IDisplayable> children = new ArrayList<>();

	@Override
	public void display() {
		displayHeader();
		children.forEach(displayable -> displayable.display());
		displayFooter();
	}

	private void displayHeader() {
		System.out.println("============Form Header=============");
	}

	private void displayFooter() {
		System.out.println("============Form Footer=============");
	}

	@Override
	public void add(IDisplayable child) {
		children.add(child);
	}

	@Override
	public void remove(IDisplayable child) {
		children.remove(child);
	}

}
