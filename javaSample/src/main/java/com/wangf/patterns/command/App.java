package com.wangf.patterns.command;

import java.util.List;

public class App {
	public static void main(String[] args) {
		Document document = new Document();
		Menu menu = Menu.createDocumentCommonMenu(document);
		menu.getMenuItems().forEach(menuItem -> menuItem.click());
		// Need record command into a stack, and pop the last command from stack
		// and doing the undo, but I do not implement the command stack here.
		List<MenuItem> items = menu.getMenuItems();
		MenuItem lastItem = items.get(items.size() - 1);
		lastItem.getCommand().undo();
	}
}
