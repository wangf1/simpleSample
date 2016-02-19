package com.wangf.patterns.chainofresponsibility;

/**
 * 1. This code mimic the Sevlet Filter API, which looks different with original
 * GoF Chain of Responsibility pattern.<br>
 * 2. This code also use the composite pattern, i.e. the {@link HandlerChain} is
 * also a {@link IHandler}
 * 
 * @author wangf
 *
 */
public class App {
	public static void main(String[] args) {
		HandlerChain chain = new HandlerChain();
		IHandler handler1 = new Hanlder1();
		chain.add(handler1);
		IHandler handler2 = new Hanlder2();
		chain.add(handler2);
		IHandler handler3 = new Hanlder3();
		chain.add(handler3);

		Request request1 = new Request("user1", "action1");
		chain.handle(request1);
		Request request2 = new Request("user2", "action2");
		chain.handle(request2);

		HandlerChain chainWithAuthenticatorAndAuditor = new HandlerChain();
		IHandler authenticator = new Authenticator();
		IHandler auditor = new Auditor();
		chainWithAuthenticatorAndAuditor.add(authenticator);
		chainWithAuthenticatorAndAuditor.add(auditor);
		chainWithAuthenticatorAndAuditor.add(chain);

		chainWithAuthenticatorAndAuditor.handle(request1);
		chainWithAuthenticatorAndAuditor.handle(request2);
	}

}
