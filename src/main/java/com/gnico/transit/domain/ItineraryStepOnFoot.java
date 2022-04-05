package com.gnico.transit.domain;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

public class ItineraryStepOnFoot extends ItineraryStep {

	private ItineraryStepOnFoot(Point startLocation, Point endLocation) {
		super(startLocation, endLocation);
	}
	
	public static ItineraryStepOnFoot create(Point startLocation, Point endLocation) {
		ItineraryStepOnFoot instance = new ItineraryStepOnFoot(startLocation, endLocation);
		instance.makeTravelPath();
		return instance;
	}
	
	private void makeTravelPath() {
		GeometryFactory gf = new GeometryFactory();
		this.travelPath = gf.createLineString(new Coordinate[] {
				new Coordinate(startLocation.getCoordinate()),
				new Coordinate(endLocation.getCoordinate())
		});
	}
	
	@Override
	public double getCost(Itinerary itinerary) {
		return itinerary.getWalkingRouteCost();
	}

	
	

}
