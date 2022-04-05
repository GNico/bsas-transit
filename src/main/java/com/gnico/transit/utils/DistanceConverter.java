package com.gnico.transit.utils;

//Not accurate but good enough appoximation
public class DistanceConverter {

	private DistanceConverter() {
		throw new IllegalStateException("Utility class");
	}
	
	public static double metersToDegree(int meters) {
		return (double) meters / 100000;
	}
	
	public static int degreeToMeters(double degrees) {
		return (int) (degrees * 100000);
	}
}
