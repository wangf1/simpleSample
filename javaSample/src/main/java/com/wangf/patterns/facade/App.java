package com.wangf.patterns.facade;

/**
 * Does folowing statement make sense??<br>
 * In my mind only encapsulate legacy system into a facade is a good idea; if
 * put new API into a facade, it may lead to a god facade that have a lot of
 * unrelated responsibility.
 * 
 * @author wangf
 *
 */
public class App {
	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.doOldThings();
		facade.doNewThings();
	}
}
