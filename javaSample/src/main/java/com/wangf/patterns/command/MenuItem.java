package com.wangf.patterns.command;

public class MenuItem {
	private ICommand command;

	public MenuItem(ICommand command) {
		this.command = command;
	}

	public void click() {
		command.execute();
	}

	public ICommand getCommand() {
		return command;
	}

}
