package com.wangf.patterns.decorator;

public class Border implements IDisplayable {

	private IDisplayable decoratee;

	public Border(IDisplayable decorated) {
		this.decoratee = decorated;
	}

	@Override
	public void display() {
		System.out.println("------------------------------");
		System.out.println("|   ");
		System.out.print("|   ");
		decoratee.display();
		System.out.println("|   ");
		System.out.println("------------------------------");
	}

}
