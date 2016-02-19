package com.wangf.patterns.chainofresponsibility;

public class Hanlder2 implements IHandler {

	@Override
	public void handle(Request request, HandlerChain chain) {
		System.out.println("Hanlder2 handle: " + request);
		if ("action2".equals(request.getAction())) {
			chain.stop();
			System.out.println(
					"For action2, Handler2 can finish the handling, and do not want following hanlder handle action2 anymore.");
		}
	}

}
