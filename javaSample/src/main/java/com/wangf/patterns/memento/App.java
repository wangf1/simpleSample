package com.wangf.patterns.memento;

/**
 * In simple case, why I bother use a memento object? I think use the Originator
 * object instead of Memento object is OK for simple case.
 * 
 * @author wangf
 *
 */
public class App {
	public static void main(String[] args) {
		// suppose I get the server configuration from a web service call
		ServerConfiguration config = new ServerConfiguration();
		System.out.println(config);

		ServerConfigMemento memento = config.getMemento();

		// suppose user change the server config on GUI, and then discard the
		// change
		config.setSetting1("new value1");
		config.setSetting2("new value2");
		System.out.println(config);

		config.restore(memento);
		System.out.println(config);
	}
}
