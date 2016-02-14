package com.wangf.patterns.abstractfactory;

public class App {
	private void createAndConsumeProduct() {
		IFactory factory = getFactoryAccordingToRuntimeEnv();
		factory.createProduct1().printName();
		// mimic the business logic to choose product2 type
		boolean needBetterProduct2 = Math.random() >= 0.5;
		Product2Type type = needBetterProduct2 ? Product2Type.BETTER_PRODUCT2 : Product2Type.GOOD_PRODUCT2;
		factory.createProduct2(type).printName();
	}

	private IFactory getFactoryAccordingToRuntimeEnv() {
		boolean isOnCloud = Math.random() < 0.5;// mimic the runtime environment
												// detect
		if (isOnCloud) {
			System.out.println("The runtime environment is on cloud.");
			return new OnCloudFactory();
		} else {
			System.out.println("The runtime environment is onpremise.");
			return new OnpremiseFactory();
		}
	}

	public static void main(String[] args) {
		App app = new App();
		for (int i = 1; i < 11; i++) {
			System.out.println("==========" + i + "===========");
			app.createAndConsumeProduct();
		}
	}
}
