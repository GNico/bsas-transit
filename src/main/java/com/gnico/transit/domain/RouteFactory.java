package com.gnico.transit.domain;

import java.util.List;

import org.locationtech.jts.geom.LineString;
import org.mapstruct.ObjectFactory;

public class RouteFactory {

	@ObjectFactory
	BusRoute createBusRoute(int routeId, boolean returnDirection, LineString path,
			String line, String branch, String description, String tripSign, List<BusStop> stops) {
		return new BusRoute(routeId, returnDirection, path, line, branch, description, tripSign, 
				stops, new BusPathGeometryCalculator());
	}

	
}
