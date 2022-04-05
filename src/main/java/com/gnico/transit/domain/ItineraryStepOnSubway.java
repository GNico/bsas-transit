package com.gnico.transit.domain;

import org.locationtech.jts.geom.Point;

public class ItineraryStepOnSubway extends ItineraryStep {

	private SubwayRoute subwayRoute;
	
	private ItineraryStepOnSubway(Point startLocation, Point endLocation, SubwayRoute subwayRoute) {
		super(startLocation, endLocation);
		this.subwayRoute = subwayRoute;
	}

	public static ItineraryStepOnSubway create(Point startLocation, Point endLocation, SubwayRoute subwayRoute) {
		ItineraryStepOnSubway instance = new ItineraryStepOnSubway(startLocation,endLocation, subwayRoute);
		instance.makeTravelPath(startLocation, endLocation);
		return instance;
	}
	
	private void makeTravelPath(Point startLocation, Point endLocation) {
		this.travelPath = subwayRoute.getTravelPathBetweenLocations(startLocation, endLocation);
	}
	
	@Override
	public double getCost(Itinerary itinerary) {
		return itinerary.getSubwayRouteCost();
	}

	public SubwayRoute getSubwayRoute() {
		return subwayRoute;
	}

	public void setSubwayRoute(SubwayRoute subwayRoute) {
		this.subwayRoute = subwayRoute;
	}
}
