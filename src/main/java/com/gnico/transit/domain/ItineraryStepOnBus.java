package com.gnico.transit.domain;

import org.locationtech.jts.geom.Point;

public class ItineraryStepOnBus extends ItineraryStep {
	
	private BusRoute busRoute;
	
	private ItineraryStepOnBus(Point startLocation, Point endLocation, BusRoute busRoute) {
		super(startLocation, endLocation);
		this.busRoute = busRoute;
	}

	public static ItineraryStepOnBus create(Point startLocation, Point endLocation, BusRoute busRoute) {
		ItineraryStepOnBus instance = new ItineraryStepOnBus(startLocation,endLocation, busRoute);
		instance.makeTravelPath(startLocation, endLocation);
		return instance;
	}
	
	private void makeTravelPath(Point startLocation, Point endLocation) {
		this.travelPath = busRoute.getTravelPathBetweenLocations(startLocation, endLocation);
	}
	
	@Override
	public double getCost(Itinerary itinerary) {
		return itinerary.getBusRouteCost();
	}

	public BusRoute getBusRoute() {
		return busRoute;
	}

	public void setBusRoute(BusRoute busRoute) {
		this.busRoute = busRoute;
	}
	
	

}
