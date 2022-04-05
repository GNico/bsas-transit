package com.gnico.transit.domain;

import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

public abstract class ItineraryStep {
	
	protected Point startLocation;
	protected Point endLocation;
	protected LineString travelPath;
	
	protected ItineraryStep(Point startLocation, Point endLocation) {
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}
		
	public abstract double getCost(Itinerary itinerary);
	
	public double getTravelDistance() {
		return this.travelPath.getLength();
	}
		
	
	public Point getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(Point startLocation) {
		this.startLocation = startLocation;
	}
	public Point getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(Point endLocation) {
		this.endLocation = endLocation;
	}
	public LineString getTravelPath() {
		return travelPath;
	}

	
}
