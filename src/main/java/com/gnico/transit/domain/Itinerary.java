package com.gnico.transit.domain;

import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Point;

public class Itinerary {
	
	private static final int WALKING_ROUTE_COST = 5;
	private static final int BUS_ROUTE_COST = 2;
	private static final int SUBWAY_ROUTE_COST = 1;
	private static final int TRAIN_ROUTE_COST = 1;
	
	private Point startLocation;
	private Point endLocation;
	private List<ItineraryStep> steps = new ArrayList<>();
	
	public Itinerary() {}
	
	public static Itinerary create(Point startLocation, Point endLocation, Route route) {
		Itinerary itinerary = new Itinerary();
		itinerary.setStartLocation(startLocation);
		itinerary.setEndLocation(endLocation);
		Point routeEntryPoint = route.getAccessPointFromLocation(startLocation);
		Point routeExitPoint = route.getAccessPointFromLocation(endLocation);
		
		itinerary.addStep(ItineraryStepOnFoot.create(startLocation, routeEntryPoint));
		itinerary.addStep(route.createItineraryStep(routeEntryPoint, routeExitPoint));
		itinerary.addStep(ItineraryStepOnFoot.create(routeExitPoint, endLocation));
		
		return itinerary;
	}
	
	public double getCost() {
		double cost = 0;
		for (ItineraryStep step : steps) {
			cost += step.getCost(this) * step.getTravelDistance();
		}
		return cost;
	}
	
	
	public void addStep(ItineraryStep step) {
		steps.add(step);
	}
	
	public double getWalkingRouteCost() {
		return Itinerary.WALKING_ROUTE_COST;
	}
	
	public double getBusRouteCost() {
		return Itinerary.BUS_ROUTE_COST;
	}
	
	public double getSubwayRouteCost() {
		return Itinerary.SUBWAY_ROUTE_COST;
	}
	
	public double getTrainRouteCost() {
		return Itinerary.TRAIN_ROUTE_COST;
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
	public List<ItineraryStep> getSteps() {
		return steps;
	}
	public void setSteps(List<ItineraryStep> steps) {
		this.steps = steps;
	}


	
	
	
	
	
}
