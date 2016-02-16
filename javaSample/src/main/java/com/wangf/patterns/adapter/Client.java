package com.wangf.patterns.adapter;

public class Client {
	public static void main(String[] args) {
		INewAPI api = new OldImplAdaptor();
		api.newMethod();
	}
}
