package com.wangf.patterns.command;

public class CloseDocumentCommand extends AbstractDocumentCommand {

	public CloseDocumentCommand(Document document) {
		super(document);
	}

	@Override
	public void execute() {
		document.close();
	}

	@Override
	public void undo() {
		ICommand open = new OpenDocumentCommand(document);
		open.execute();
	}

}
