package com.wangf.patterns.command;

public class SaveDocumentCommand extends AbstractDocumentCommand {

	public SaveDocumentCommand(Document document) {
		super(document);
	}

	@Override
	public void execute() {
		document.save();
	}

	@Override
	public void undo() {
		document.unsave();
	}

}
