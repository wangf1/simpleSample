package com.wangf.patterns.mediator;

public class Mediator implements IMediator {

	private Button button;
	private Combobox combobox;
	private Label label;

	@Override
	public void widgetChanged(AbstractWidget widget) {
		if (widget instanceof Combobox) {
			comboboxSelectionChanged((Combobox) widget);
		} else if (widget instanceof Button) {
			buttonClicked();
		}
	}

	private void comboboxSelectionChanged(Combobox combobox) {
		int i = combobox.getSelectIndex();
		label.setText("Selected index: " + i);
		if (i != 0) {
			button.setEnabled(true);
		}
	}

	private void buttonClicked() {
		// The button click is to reset the combobox selection.
		combobox.setSelectIndex(0);
	}

	@Override
	public void addWidget(AbstractWidget widget) {
		if (widget instanceof Combobox) {
			combobox = (Combobox) widget;
		} else if (widget instanceof Label) {
			label = (Label) widget;
		} else if (widget instanceof Button) {
			button = (Button) widget;
		}
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public void setCombobox(Combobox combobox) {
		this.combobox = combobox;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

}
