package com.wangf.patterns.facade;

public class Facade {

	public void doOldThings() {
		System.out.println("------Do old things by calling legacy subsystems-------");

		LegacySubsystem1 subsystem1 = new LegacySubsystem1();
		subsystem1.doThis();
		subsystem1.doThat();

		LegacySubsystem2 subsystem2 = new LegacySubsystem2();
		subsystem2.doThis();
		subsystem2.doThat();
	}

	public void doNewThings() {
		System.out.println("======Put new API into facade may be not a good idea??=======");
	}

}
