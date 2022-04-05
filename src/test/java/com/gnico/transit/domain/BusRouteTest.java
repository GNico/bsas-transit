package com.gnico.transit.domain;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;


class BusRouteTest {
	
	BusRoute route;
	final GeometryFactory gf = new GeometryFactory();
	final PathGeometryCalculator pathGeomCalculator = new BusPathGeometryCalculator();

	@BeforeEach
	void createRouteWithPath() {
		route = new BusRoute();
		LineString path = gf.createLineString(new Coordinate[] {
				new Coordinate(2, 8),
				new Coordinate(4, 4),
				new Coordinate(8,2),
				new Coordinate(12,4),
				new Coordinate(18,4)
		});
		route.setPath(path);
		route.setPathGeomCalculator(pathGeomCalculator);
	}
		
	private static Stream<Arguments> accessPoints() {
	    return Stream.of(
	    		arguments(2, 6, 2, 8),
	            arguments(4, 6, 4, 4),
	            arguments(4, 4, 4, 4)
	    );
	}
	
	@ParameterizedTest
	@MethodSource("accessPoints")
	void testFindClosestAccessPointToLocation(double lat, double lon, double expectedLat, double expectedLon) {		
		Point closestPoint = route.getAccessPointFromLocation(gf.createPoint(new Coordinate(lat, lon)));
		assertEquals(expectedLat, closestPoint.getX());
		assertEquals(expectedLon, closestPoint.getY());
	}
	
	@Test
	void testGivenTwoLocationsFindIfRouteHasRightDirection() {		
		assertTrue(route.isRightDirection(gf.createPoint(new Coordinate(5, 10)), 
				gf.createPoint(new Coordinate(20, 5))));
		assertTrue(route.isRightDirection(gf.createPoint(new Coordinate(4, 4)), 
				gf.createPoint(new Coordinate(12, 4))));		
	}
	
	@Test
	void testGivenTwoLocationsFindIfRouteHasWrongDirection() {
		assertFalse(route.isRightDirection(gf.createPoint(new Coordinate(20, 10)), 
				gf.createPoint(new Coordinate(10, 0))));
		assertFalse(route.isRightDirection(gf.createPoint(new Coordinate(15, 5)), 
				gf.createPoint(new Coordinate(-5, 1))));
	}
	
	@Test
	void testFindTravelPath() {
		LineString path = route.getTravelPathBetweenLocations(gf.createPoint(new Coordinate(2, 8)), 
				gf.createPoint(new Coordinate(8, 2)));
		Coordinate[] travelCoords = path.getCoordinates();
		assertEquals(3, travelCoords.length);
		assertEquals(0, travelCoords[0].compareTo(new Coordinate(2, 8)));
		assertEquals(0, travelCoords[travelCoords.length-1].compareTo(new Coordinate(8, 2)));				
	}
	
	@Test
	void testFindTravelPathOppositeDirection() {
		LineString path = route.getTravelPathBetweenLocations(gf.createPoint(new Coordinate(8, 2)), 
				gf.createPoint(new Coordinate(2, 8)));
		Coordinate[] travelCoords = path.getCoordinates();
		assertEquals(3, travelCoords.length);
		assertEquals(0, travelCoords[0].compareTo(new Coordinate(8, 2)));
		assertEquals(0, travelCoords[travelCoords.length-1].compareTo(new Coordinate(2, 8)));					
	}
}
