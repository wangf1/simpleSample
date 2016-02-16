package com.wangf.patterns.bridge;

public class ServcieImplHANA implements IServcieImpl {

	@Override
	public void accessDatabase(String sql) {
		System.out.println("Access HANA DB:" + sql);
	}

}
