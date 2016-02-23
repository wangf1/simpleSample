package com.wangf.patterns.command;

public class OpenDocumentCommand extends AbstractDocumentCommand {
	public OpenDocumentCommand(Document document) {
		super(document);
	}

	@Override
	public void execute() {
		document.open();
	}

	@Override
	public void undo() {
		ICommand close = new CloseDocumentCommand(document);
		close.execute();
	}

}
