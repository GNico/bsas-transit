package com.gnico.transit.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

class ItineraryStepOnBusTest {

	final GeometryFactory gf = new GeometryFactory();
	BusRoute route;
	final PathGeometryCalculator pathGeomCalculator = new BusPathGeometryCalculator();

	
	@BeforeEach
	void createRoute() {
		route = new BusRoute();
		LineString path = gf.createLineString(new Coordinate[] {
				new Coordinate(2, 8),
				new Coordinate(4, 4),
				new Coordinate(8, 2),
				new Coordinate(12,4),
				new Coordinate(18,4)
		});
		route.setPath(path);
		route.setPathGeomCalculator(pathGeomCalculator);
	}
	
	@Test
	void testTravelPathCreationPointsInside() {
		Point startLocation = gf.createPoint(new Coordinate(4, 4));
		Point endLocation = gf.createPoint(new Coordinate(12, 4));
		
		ItineraryStepOnBus step = ItineraryStepOnBus.create(startLocation, endLocation, route);
		
		LineString travelPath = step.getTravelPath();
		assertEquals(3, travelPath.getNumPoints());
		assertEquals(0, startLocation.compareTo(travelPath.getStartPoint()));
		assertEquals(0, endLocation.compareTo(travelPath.getEndPoint()));
	}
	
	@Test
	void testTravelPathCreationPointsOutside() {
		Point startLocation = gf.createPoint(new Coordinate(2, 4));
		Point endLocation = gf.createPoint(new Coordinate(12, 2));
		
		ItineraryStepOnBus step = ItineraryStepOnBus.create(startLocation, endLocation, route);
		
		LineString travelPath = step.getTravelPath();
		assertEquals(3, travelPath.getNumPoints());
		assertEquals(0, travelPath.getStartPoint().getCoordinate().compareTo(new Coordinate(4, 4)));
		assertEquals(0, travelPath.getEndPoint().getCoordinate().compareTo(new Coordinate(12, 4)));
	}
}
