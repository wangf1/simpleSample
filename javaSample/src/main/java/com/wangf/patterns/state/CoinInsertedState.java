package com.wangf.patterns.state;

public class CoinInsertedState extends AbstractState {

	public CoinInsertedState(CandyMachine candyMachine) {
		super(candyMachine);
	}

	@Override
	public void insertCoin() {
		System.out.println("Coin already insert, cannot insert coin again.");
	}

	@Override
	public void turnCrank() {
		System.out.println("Crank turned, please take your candy.");
		candyMachine.ejectsACandy();
		if (candyMachine.getCandyCount() > 0) {
			candyMachine.toState(STATE_TYPE.READY_TO_SELL);
		} else {
			candyMachine.toState(STATE_TYPE.SOLD_OUT);
		}
	}

	@Override
	public void ejectsCoin() {
		System.out.println("Eject coin button pushed, please take back your coin.");
		candyMachine.toState(STATE_TYPE.READY_TO_SELL);
	}

}
