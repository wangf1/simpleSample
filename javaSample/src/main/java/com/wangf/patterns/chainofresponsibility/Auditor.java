package com.wangf.patterns.chainofresponsibility;

public class Auditor implements IHandler {

	@Override
	public void handle(Request request, HandlerChain chain) {
		System.out.println("Recording audit log: User: " + request.getUser() + " doing action: " + request.getAction());
	}

}
