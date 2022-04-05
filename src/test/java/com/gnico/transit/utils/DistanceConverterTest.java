package com.gnico.transit.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DistanceConverterTest {

	@ParameterizedTest
	@CsvSource({"0.00553123, 553", "0.01, 1000", "0, 0"})
	void test_degreesToMeters(double input, int expected) {
		assertEquals(expected, DistanceConverter.degreeToMeters(input));
	}
	
	@ParameterizedTest
	@CsvSource({"345, 0.00345", "12345, 0.12345", "0, 0"})
	void test_metersToDegree(int input, double expected) {
		assertEquals(expected, DistanceConverter.metersToDegree(input));
	}

}
