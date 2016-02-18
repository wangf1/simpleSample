package com.wangf.patterns.flyweight;

/**
 * Flyweight pattern seems just a cache of immutable objects.
 * 
 * @author wangf
 *
 */
public class App {
	public static void main(String[] args) {
		Color red = Color.getColor("red");
		Color red2 = Color.getColor("red");
		Color green = Color.getColor("green");
		Color blue = Color.getColor("blue");

		System.out.println(red + " == " + red2 + ": " + red.equals(red2));
		System.out.println(green);
		System.out.println(blue);
	}
}
