package com.wangf.patterns.bridge;

/**
 * TODO: Below understand accurate or not? <br>
 * The bridge pattern looks like two set of separate hierarchy: client side
 * hierarchy and server side hierarchy.<br>
 * Client side implementation use server side implementation.<br>
 * Client side implementation and server side implementation have all kinds of
 * combination.<br>
 * Both side can vary independently.<br>
 *
 * @author wangf
 *
 */
public class App {
	public static void main(String[] args) {
		IServcieImpl implForHANA = new ServcieImplHANA();
		IServcie onpremiseHANA = new OnpemiseService(implForHANA);
		onpremiseHANA.getCustomerAndOrders("Customer123");

		IServcie onCloudHANA = new OnCloudService(implForHANA);
		onCloudHANA.getCustomerAndOrders("Customer456");

		IServcieImpl implForOracle = new ServcieImplOracle();
		IServcie onpremiseOracle = new OnpemiseService(implForOracle);
		onpremiseOracle.getCustomerAndOrders("Customer123");

		IServcie onCloudOracle = new OnCloudService(implForOracle);
		onCloudOracle.getCustomerAndOrders("Customer456");

	}
}
