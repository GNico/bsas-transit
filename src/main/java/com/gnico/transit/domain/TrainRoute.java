package com.gnico.transit.domain;

import java.util.List;

import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

public class TrainRoute implements Route {

	private String line;
	private String branch;
	private String fullName;
	private String headsign;
	private LineString path;
	private PathGeometryCalculator pathGeomCalculator;
	private List<TrainStop> stops;
	
	public TrainRoute(String line, String branch, String fullName, String headsign, LineString path,
			PathGeometryCalculator pathGeomCalculator, List<TrainStop> stops) {
		this.line = line;
		this.branch = branch;
		this.fullName = fullName;
		this.headsign = headsign;
		this.path = path;
		this.pathGeomCalculator = pathGeomCalculator;
		this.stops = stops;
	}
	
	@Override
	public String getUniqueId() {
		return "train" + this.line + this.branch;
	}
	
	@Override
	public boolean isBidirectional() {
		return true;
	}
	
	@Override
	public boolean isRightDirection(Point startLocation, Point endLocation) {
		return this.pathGeomCalculator.isRightDirection(path, startLocation, endLocation);
	}
	
	@Override
	public Point getAccessPointFromLocation(Point location) {
		return this.pathGeomCalculator.getClosestPointOnLineStringFromLocation(path, location);
	}
	
	@Override
	public LineString getTravelPathBetweenLocations(Point startLocation, Point endLocation) {
		return this.pathGeomCalculator.getLineStringBetweenPoints(path, startLocation, endLocation);
	}
	
	@Override
	public ItineraryStep createItineraryStep(Point startLocation, Point endLocation) {
		return ItineraryStepOnTrain.create(startLocation, endLocation, this);
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getHeadsign() {
		return headsign;
	}
	public void setHeadsign(String headsign) {
		this.headsign = headsign;
	}
	public LineString getPath() {
		return path;
	}
	public void setPath(LineString path) {
		this.path = path;
	}
	public PathGeometryCalculator getPathGeomCalculator() {
		return pathGeomCalculator;
	}
	public void setPathGeomCalculator(PathGeometryCalculator pathGeomCalculator) {
		this.pathGeomCalculator = pathGeomCalculator;
	}
	public List<TrainStop> getStops() {
		return stops;
	}
	public void setStops(List<TrainStop> stops) {
		this.stops = stops;
	}
	
	

	
}
