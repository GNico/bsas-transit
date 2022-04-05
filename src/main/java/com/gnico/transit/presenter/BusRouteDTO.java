package com.gnico.transit.presenter;

import java.util.List;

import org.locationtech.jts.geom.LineString;
import org.n52.jackson.datatype.jts.GeometrySerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class BusRouteDTO {

	private String uniqueRouteId;
	private int routeId;
	private boolean returnDirection = false;
	@JsonSerialize(using = GeometrySerializer.class)
	private LineString path;
	private String line;
	private String branch;
	private String description;
	private String tripSign;
	private List<BusStopDTO> stops;
	private final String type = "bus";

	public BusRouteDTO() {}

	public String getUniqueRouteId() {
		return uniqueRouteId;
	}

	public void setUniqueRouteId(String uniqueRouteId) {
		this.uniqueRouteId = uniqueRouteId;
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

	public List<BusStopDTO> getStops() {
		return stops;
	}

	public void setStops(List<BusStopDTO> stops) {
		this.stops = stops;
	}

	public String getType() {
		return type;
	}
	
}
