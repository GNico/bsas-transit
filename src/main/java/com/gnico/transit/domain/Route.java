package com.gnico.transit.domain;

import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

public interface Route {

	String getUniqueId();
	
	boolean isBidirectional();
	
	boolean isRightDirection(Point startLocation, Point endLocation);
	
	Point getAccessPointFromLocation(Point location);
	
	LineString getTravelPathBetweenLocations(Point startLocation, Point endLocation);
	
	ItineraryStep createItineraryStep(Point startLocation, Point endLocation);
}
