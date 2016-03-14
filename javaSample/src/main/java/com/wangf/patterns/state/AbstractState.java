package com.wangf.patterns.state;

public abstract class AbstractState implements IState {

	protected CandyMachine candyMachine;

	public AbstractState(CandyMachine candyMachine) {
		this.candyMachine = candyMachine;
	}
}
