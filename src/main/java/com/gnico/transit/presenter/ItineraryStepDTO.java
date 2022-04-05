package com.gnico.transit.presenter;

import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.n52.jackson.datatype.jts.GeometrySerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ItineraryStepDTO {

	private String type;
	@JsonSerialize(using = GeometrySerializer.class)
	private Point startLocation;
	@JsonSerialize(using = GeometrySerializer.class)
	private Point endLocation;
	@JsonSerialize(using = GeometrySerializer.class)
	private LineString travelPath;
	private BusRouteDTO busRoute;
	private SubwayRouteDTO subwayRoute;
	private int travelDistance;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public void setTravelPath(LineString travelPath) {
		this.travelPath = travelPath;
	}
	public BusRouteDTO getBusRoute() {
		return busRoute;
	}
	public void setBusRoute(BusRouteDTO busRoute) {
		this.busRoute = busRoute;
	}
	public SubwayRouteDTO getSubwayRoute() {
		return subwayRoute;
	}
	public void setSubwayRoute(SubwayRouteDTO subwayRoute) {
		this.subwayRoute = subwayRoute;
	}
	public int getTravelDistance() {
		return travelDistance;
	}
	public void setTravelDistance(int travelDistance) {
		this.travelDistance = travelDistance;
	}

	
}
