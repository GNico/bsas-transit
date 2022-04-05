package com.gnico.transit.interactors;

import java.util.List;

import com.gnico.transit.domain.SubwayRoute;

public interface SubwayDataGateway {
	
	List<String> findAllSubwayLines();
	
	List<String> findLinesCloseTo(double lat, double lon, double distance);

	SubwayRoute findRouteForLine(String line);

	List<SubwayRoute> findRoutesCloseToLocation(double lat, double lon, double maxDistance);

}
