package com.wangf.patterns.chainofresponsibility;

public class Authenticator implements IHandler {

	@Override
	public void handle(Request request, HandlerChain chain) {
		if ("user2".equals(request.getUser())) {
			System.out.println("We do not want user2 access the system");
			chain.stop();
		}

	}

}
