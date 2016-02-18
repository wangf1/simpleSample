package com.wangf.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Color {

	private static Map<String, Color> colorCache = new HashMap<>();

	private String color;

	private Color(String colorKey) {
		this.color = colorKey;
	}

	public static Color getColor(String colorKey) {
		// Not yet consider thread safe
		Color color = colorCache.get(colorKey);
		if (color == null) {
			color = new Color(colorKey);
			colorCache.put(colorKey, color);
		}
		return color;
	}

	@Override
	public String toString() {
		return "Color@" + Integer.toHexString(hashCode()) + " [color=" + color + "]";
	}

}
