package com.gnico.transit.domain;

import org.locationtech.jts.geom.Point;

public class ItineraryStepOnTrain extends ItineraryStep {

	private TrainRoute trainRoute;
	
	private ItineraryStepOnTrain(Point startLocation, Point endLocation, TrainRoute trainRoute) {
		super(startLocation, endLocation);
		this.trainRoute = trainRoute;
	}
	
	public static ItineraryStepOnTrain create(Point startLocation, Point endLocation, TrainRoute trainRoute) {
		ItineraryStepOnTrain instance = new ItineraryStepOnTrain(startLocation,endLocation, trainRoute);
		instance.makeTravelPath(startLocation, endLocation);
		return instance;
	}
	
	private void makeTravelPath(Point startLocation, Point endLocation) {
		this.travelPath = trainRoute.getTravelPathBetweenLocations(startLocation, endLocation);
	}
	
	@Override
	public double getCost(Itinerary itinerary) {
		return itinerary.getTrainRouteCost();
	}

	public TrainRoute getSubwayRoute() {
		return trainRoute;
	}

	public void setSubwayRoute(TrainRoute trainRoute) {
		this.trainRoute = trainRoute;
	}

}
