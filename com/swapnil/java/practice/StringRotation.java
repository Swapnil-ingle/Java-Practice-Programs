package com.swapnil.java.practice;

public class StringRotation {
	public static void main(String[] args) {
		String s1 = "WaterBottle"; // x = Water; y = Bottle
		String s2 = "BottleWater"; // y = Bottle; x = Water
		
		System.out.println(isRotation(s1, s2));
	}
	
	private static boolean isRotation(String s1, String s2) {
		if (s1.length() == s2.length() && s1.length() > 0) {
			String xyxy = s1 + s1;
			
			return xyxy.contains(s2);
		}
		
		return false;
	}
}
