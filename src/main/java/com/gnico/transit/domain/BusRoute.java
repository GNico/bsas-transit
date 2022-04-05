package com.gnico.transit.domain;

import java.util.List;

import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

public class BusRoute implements Route {

	private int routeId;
	private boolean returnDirection = false;	
	private LineString path;
	private String line;
	private String branch;
	private String description;
	private String tripSign;
	private List<BusStop> stops;
	private PathGeometryCalculator pathGeomCalculator;
	
	public BusRoute() {}

	public BusRoute(int routeId, boolean returnDirection, LineString path, String line, String branch,
			String description, String tripSign, List<BusStop> stops, PathGeometryCalculator pathGeomCalculator) {
		this.routeId = routeId;
		this.returnDirection = returnDirection;
		this.path = path;
		this.line = line;
		this.branch = branch;
		this.description = description;
		this.tripSign = tripSign;
		this.stops = stops;
		this.pathGeomCalculator = pathGeomCalculator;
	}
	
	@Override
	public ItineraryStep createItineraryStep(Point startLocation, Point endLocation) {
		return ItineraryStepOnBus.create(startLocation, endLocation, this);
	}

	@Override
	public String getUniqueId() {
		return String.valueOf(this.routeId) + (this.returnDirection ? "return" : "onward");
	}
	
	@Override
	public boolean isBidirectional() {
		return false;
	}

	public Point getAccessPointFromLocation(Point location) {
		return this.pathGeomCalculator.getClosestPointOnLineStringFromLocation(path, location);
	}
	
	public LineString getTravelPathBetweenLocations(Point startLocation, Point endLocation) {
		return this.pathGeomCalculator.getLineStringBetweenPoints(path, startLocation, endLocation);
	}
	
	public boolean isRightDirection(Point startLocation, Point endLocation) {
		return this.pathGeomCalculator.isRightDirection(path, startLocation, endLocation);
	}
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTripSign() {
		return tripSign;
	}

	public void setTripSign(String tripSign) {
		this.tripSign = tripSign;
	}	

	public LineString getPath() {
		return path;
	}

	public void setPath(LineString path) {
		this.path = path;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public boolean isReturnDirection() {
		return returnDirection;
	}

	public void setReturnDirection(boolean returnDirection) {
		this.returnDirection = returnDirection;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public List<BusStop> getStops() {
		return stops;
	}

	public void setStops(List<BusStop> stops) {
		this.stops = stops;
	}

	public PathGeometryCalculator getPathGeomCalculator() {
		return pathGeomCalculator;
	}

	public void setPathGeomCalculator(PathGeometryCalculator pathGeomCalculator) {
		this.pathGeomCalculator = pathGeomCalculator;
	}

	
	
	
	
	
}
