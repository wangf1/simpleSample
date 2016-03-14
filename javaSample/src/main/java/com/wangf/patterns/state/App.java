package com.wangf.patterns.state;

public class App {
	public static void main(String[] args) {
		CandyMachine machine = new CandyMachine();
		machine.installCandy(2);

		machine.turnCrank();
		machine.insertCoin();
		machine.insertCoin();
		machine.turnCrank();
		machine.insertCoin();
		machine.ejectsCoin();
		machine.ejectsCoin();
		machine.insertCoin();
		machine.turnCrank();
		machine.insertCoin();
		machine.turnCrank();
	}

}
