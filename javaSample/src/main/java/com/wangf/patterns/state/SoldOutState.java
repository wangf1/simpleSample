package com.wangf.patterns.state;

public class SoldOutState extends AbstractState {

	public SoldOutState(CandyMachine candyMachine) {
		super(candyMachine);
	}

	@Override
	public void insertCoin() {
		System.out.println("Candy sold out, please take back your coin.");
	}

	@Override
	public void turnCrank() {
		System.out.println("Candy sold out, and not insert coin.");
	}

	@Override
	public void ejectsCoin() {
		System.out.println("You did not insert a coin, so cannot eject coin.");
	}

}
