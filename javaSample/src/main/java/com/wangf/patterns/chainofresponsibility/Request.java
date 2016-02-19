package com.wangf.patterns.chainofresponsibility;

public class Request {

	private String user;
	private String action;

	public Request(String user, String action) {
		this.user = user;
		this.action = action;
	}

	public String getUser() {
		return user;
	}

	public String getAction() {
		return action;
	}

	@Override
	public String toString() {
		return "Request [user=" + user + ", action=" + action + "]";
	}

}
