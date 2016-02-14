package com.wangf.patterns.abstractfactory;

public interface IFactory {

	IProduct1 createProduct1();

	IProduct2 createProduct2(Product2Type type);
}
