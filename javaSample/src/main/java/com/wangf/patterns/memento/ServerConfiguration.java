package com.wangf.patterns.memento;

public class ServerConfiguration {

	private String setting1 = "default1";
	private String setting2 = "default2";

	public ServerConfigMemento getMemento() {
		ServerConfigMemento memento = new ServerConfigMemento();
		memento.setSetting1(setting1);
		memento.setSetting2(setting2);
		return memento;
	}

	public void restore(ServerConfigMemento memento) {
		setting1 = memento.getSetting1();
		setting2 = memento.getSetting2();
	}

	public String getSetting1() {
		return setting1;
	}

	public void setSetting1(String setting1) {
		this.setting1 = setting1;
	}

	public String getSetting2() {
		return setting2;
	}

	public void setSetting2(String setting2) {
		this.setting2 = setting2;
	}

	@Override
	public String toString() {
		return "ServerConfiguration [setting1=" + setting1 + ", setting2=" + setting2 + "]";
	}

}
