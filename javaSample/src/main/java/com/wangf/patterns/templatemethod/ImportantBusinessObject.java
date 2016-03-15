package com.wangf.patterns.templatemethod;

public class ImportantBusinessObject {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ImportantBusinessObject [value=" + value + "]";
	}

}
