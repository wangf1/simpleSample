package com.wangf.patterns.state;

public class ReadyToSellState extends AbstractState {

	public ReadyToSellState(CandyMachine candyMachine) {
		super(candyMachine);
	}

	@Override
	public void insertCoin() {
		System.out.println("Inserted a coin.");
		candyMachine.toState(STATE_TYPE.COIN_INSERTED);
	}

	@Override
	public void turnCrank() {
		System.out.println("Please insert a coin before trun the crank.");
	}

	@Override
	public void ejectsCoin() {
		System.out.println("Please take back your coin.");
		candyMachine.toState(STATE_TYPE.READY_TO_SELL);
	}

}
