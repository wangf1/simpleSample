package com.wangf.patterns.state;

public class CandyMachine {

	private int candyCount;
	private IState currentState;
	private IState soldOutState;
	private IState coinInsertedState;
	private IState readyToSellState;

	public CandyMachine() {
		soldOutState = new SoldOutState(this);
		coinInsertedState = new CoinInsertedState(this);
		readyToSellState = new ReadyToSellState(this);
		currentState = soldOutState;
	}

	public void installCandy(int candyCount) {
		this.candyCount = candyCount;
		currentState = readyToSellState;
	}

	public void insertCoin() {
		System.out.println("---Current state: " + currentState.getClass().getSimpleName() + "---");
		currentState.insertCoin();
	}

	public void turnCrank() {
		System.out.println("---Current state: " + currentState.getClass().getSimpleName() + "---");
		currentState.turnCrank();
	}

	public void ejectsCoin() {
		System.out.println("---Current state: " + currentState.getClass().getSimpleName() + "---");
		currentState.ejectsCoin();
	}

	public int getCandyCount() {
		return candyCount;
	}

	public void toState(STATE_TYPE stateType) {
		System.out.println("---To state: " + stateType + "---");
		switch (stateType) {
		case READY_TO_SELL:
			currentState = readyToSellState;
			break;
		case COIN_INSERTED:
			currentState = coinInsertedState;
			break;
		case SOLD_OUT:
			currentState = soldOutState;
		default:
			break;
		}
	}

	public void ejectsACandy() {
		candyCount--;
	}

}
