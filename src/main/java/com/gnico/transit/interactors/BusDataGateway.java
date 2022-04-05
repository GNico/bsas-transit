package com.gnico.transit.interactors;

import java.util.List;

import com.gnico.transit.domain.BusRoute;
import com.gnico.transit.domain.BusStop;

public interface BusDataGateway {
	
	List<String> findAllBusLines();
	
	List<String> findLinesCloseTo(double lat, double lon, double distance);
	
	List<BusRoute> findRoutesForLine(String linea);
	
	List<BusStop> findStopsForRouteAndDirection(int routeId, boolean returnDirection);

	List<BusRoute> findRoutesCloseToLocation(double lat, double lon, double distance);


}
