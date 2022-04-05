package com.gnico.transit.domain;

import java.util.List;

import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

public class SubwayRoute implements Route {

	private String line;
	private List<SubwayStop> stops;
	private LineString path;
	private PathGeometryCalculator pathGeomCalculator;
	private String color;
	private String name;
	
	public SubwayRoute(String line, List<SubwayStop> stops, LineString path, String color, String name,
			PathGeometryCalculator pathGeomCalculator) {
		this.line = line;
		this.stops = stops;
		this.path = path;
		this.color = color;
		this.name = name;
		this.pathGeomCalculator = pathGeomCalculator;
	}

	@Override
	public String getUniqueId() {
		return "subte" + this.line;
	}

	@Override
	public boolean isBidirectional() {
		return true;
	}

	@Override
	public ItineraryStep createItineraryStep(Point startLocation, Point endLocation) {
		return ItineraryStepOnSubway.create(startLocation, endLocation, this);
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
	public boolean isRightDirection(Point startLocation, Point endLocation) {
		return this.pathGeomCalculator.isRightDirection(path, startLocation, endLocation);
	}	
	
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public List<SubwayStop> getStops() {
		return stops;
	}
	public void setStops(List<SubwayStop> stops) {
		this.stops = stops;
	}
	public LineString getPath() {
		return path;
	}
	public void setPath(LineString path) {
		this.path = path;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	


}
