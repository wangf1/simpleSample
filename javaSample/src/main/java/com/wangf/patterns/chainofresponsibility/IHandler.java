package com.wangf.patterns.chainofresponsibility;

public interface IHandler {
	void handle(Request request, HandlerChain chain);
}
