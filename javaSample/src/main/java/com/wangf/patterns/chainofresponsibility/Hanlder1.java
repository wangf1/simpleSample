package com.wangf.patterns.chainofresponsibility;

public class Hanlder1 implements IHandler {

	@Override
	public void handle(Request request, HandlerChain chain) {
		System.out.println("Hanlder1 handle: " + request);
	}

}
