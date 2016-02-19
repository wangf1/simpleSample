package com.wangf.patterns.chainofresponsibility;

public class Hanlder3 implements IHandler {

	@Override
	public void handle(Request request, HandlerChain chain) {
		System.out.println("Hanlder3 handle: " + request);
	}

}
