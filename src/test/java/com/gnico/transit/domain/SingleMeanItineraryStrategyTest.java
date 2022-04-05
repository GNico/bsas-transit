package com.gnico.transit.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SingleMeanItineraryStrategyTest {

	private final GeometryFactory gf = new GeometryFactory();
	
	@Mock
	RouteFinder routeFinder;
	final PathGeometryCalculator pathGeomCalculator = new BusPathGeometryCalculator();

	@Test
	void testFindItineraries() {	
		Point startLocation = gf.createPoint(new Coordinate(4, 8));
		Point endLocation = gf.createPoint(new Coordinate(9, 2));
		List<Route> startRoutes = new ArrayList<>();
		startRoutes.add(createRoute1());
		startRoutes.add(createRoute2());
		startRoutes.add(createRoute4());				
		startRoutes.add(createRoute1_OtherDirection());				
		List<Route> endRoutes = new ArrayList<>();
		endRoutes.add(createRoute1());
		endRoutes.add(createRoute2());
		endRoutes.add(createRoute3());
		endRoutes.add(createRoute1_OtherDirection());				
		when(routeFinder.findRoutesCloseToLocation(anyDouble(), anyDouble(), anyDouble()))
		.thenReturn(startRoutes).thenReturn(endRoutes);
		
		SingleMeanItineraryStrategy strategy = new SingleMeanItineraryStrategy(routeFinder);
		List<Itinerary> itineraries = strategy.calculateItineraries(startLocation, endLocation, 0.1);
		BusRoute itRoute = ((ItineraryStepOnBus) itineraries.get(0).getSteps().get(1)).getBusRoute();
		BusRoute itRoute2 = ((ItineraryStepOnBus) itineraries.get(1).getSteps().get(1)).getBusRoute();
		
		verify(routeFinder, times(2)).findRoutesCloseToLocation(anyDouble(), anyDouble(), anyDouble());
		assertEquals(2, itineraries.size());
		assertEquals("1onward", itRoute.getUniqueId());
		assertEquals("2onward", itRoute2.getUniqueId());
	} 
		
	
	private BusRoute createRoute1() {
		BusRoute route = new BusRoute();
		route.setRouteId(1);
		route.setLine("F");
		route.setPathGeomCalculator(pathGeomCalculator);
		LineString path = gf.createLineString(new Coordinate[] {
				new Coordinate(2, 8),
				new Coordinate(4, 4),
				new Coordinate(8,2),
				new Coordinate(12,4),
				new Coordinate(18,4)
		});
		route.setPath(path);
		return route;
	}
	
	private BusRoute createRoute2() {
		BusRoute route = new BusRoute();
		route.setRouteId(2);
		route.setLine("G");
		route.setPathGeomCalculator(pathGeomCalculator);
		LineString path = gf.createLineString(new Coordinate[] {
				new Coordinate(4, 10),
				new Coordinate(6, 6),
				new Coordinate(6, 1),
				new Coordinate(13, -1),
		});
		route.setPath(path);
		return route;
	}
	
	private BusRoute createRoute3() {
		BusRoute route = new BusRoute();
		route.setRouteId(3);
		route.setLine("H");
		route.setPathGeomCalculator(pathGeomCalculator);
		LineString path = gf.createLineString(new Coordinate[] {
				new Coordinate(10, 12),
				new Coordinate(12, 8),
				new Coordinate(14, 6),
				new Coordinate(16, 2),
		});
		route.setPath(path);
		return route;
	}
	
	private BusRoute createRoute4() {
		BusRoute route = new BusRoute();
		route.setRouteId(4);
		route.setLine("I");
		route.setPathGeomCalculator(pathGeomCalculator);
		LineString path = gf.createLineString(new Coordinate[] {
				new Coordinate(2, 6),
				new Coordinate(4, 6),
				new Coordinate(10, 6),
				new Coordinate(18, 6),
		});
		route.setPath(path);
		return route;
	}
	
	private BusRoute createRoute1_OtherDirection() {
		BusRoute route = new BusRoute();
		route.setRouteId(5);
		route.setReturnDirection(true);
		route.setLine("F");
		route.setPathGeomCalculator(pathGeomCalculator);
		LineString path = gf.createLineString(new Coordinate[] {
				new Coordinate(18,4),
				new Coordinate(12,4),
				new Coordinate(8,2),
				new Coordinate(4, 4),
				new Coordinate(2, 8),
		});
		route.setPath(path);
		return route;
	}

}
