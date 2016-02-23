package com.wangf.patterns.command;

public abstract class AbstractDocumentCommand implements ICommand {

	protected Document document;

	public AbstractDocumentCommand(Document document) {
		this.document = document;
	}

}
