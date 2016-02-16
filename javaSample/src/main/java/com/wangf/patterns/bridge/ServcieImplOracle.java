package com.wangf.patterns.bridge;

public class ServcieImplOracle implements IServcieImpl {

	@Override
	public void accessDatabase(String sql) {
		System.out.println("Access Oracle DB:" + sql);
	}

}
