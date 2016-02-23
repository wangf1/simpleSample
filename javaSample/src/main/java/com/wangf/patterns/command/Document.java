package com.wangf.patterns.command;

public class Document {

	public void open() {
		System.out.println("Document opened.");
	}

	public void save() {
		System.out.println("Document saved.");
	}

	public void close() {
		System.out.println("Document closed.");
	}

	public void unsave() {
		System.out.println("Discard last saved change.");
	}

}
