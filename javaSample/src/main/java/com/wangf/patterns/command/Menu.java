package com.wangf.patterns.command;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<MenuItem> menuItems = new ArrayList<>();

	private Menu() {
	}

	public void addMenuItem(MenuItem item) {
		menuItems.add(item);
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public static Menu createDocumentCommonMenu(Document document) {
		Menu menu = new Menu();

		ICommand open = new OpenDocumentCommand(document);
		MenuItem openMemu = new MenuItem(open);

		ICommand save = new SaveDocumentCommand(document);
		MenuItem saveMemu = new MenuItem(save);

		ICommand close = new CloseDocumentCommand(document);
		MenuItem closeMemu = new MenuItem(close);

		menu.addMenuItem(openMemu);
		menu.addMenuItem(saveMemu);
		menu.addMenuItem(closeMemu);
		return menu;
	}
}
