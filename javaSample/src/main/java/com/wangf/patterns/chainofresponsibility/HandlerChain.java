package com.wangf.patterns.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain implements IHandler {

	private List<IHandler> handlers = new ArrayList<>();
	/**
	 * If set to false, this handler chain will stop handle current request.
	 */
	private boolean needContinue = true;

	@Override
	public void handle(Request request, HandlerChain chain) {
		for (IHandler handler : handlers) {
			handler.handle(request, chain);
		}
	}

	public void handle(Request request) {
		System.out.println("========Hanlder chain begin handing=============");
		for (IHandler handler : handlers) {
			handler.handle(request, this);
			if (needContinue == false) {
				break;
			}
		}
		// reset to true in order to make the chain ready to handle next request
		needContinue = true;
		System.out.println("========Hanlder chain finished handing=============");
	}

	public void add(IHandler handler) {
		handlers.add(handler);
	}

	public void stop() {
		needContinue = false;
	}
}
