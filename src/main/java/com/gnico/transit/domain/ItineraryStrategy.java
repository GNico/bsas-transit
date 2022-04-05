package com.gnico.transit.domain;

import java.util.List;

import org.locationtech.jts.geom.Point;

public interface ItineraryStrategy {

	List<Itinerary> calculateItineraries(Point startLocation, Point endLocation, double maxDistance);
	
}