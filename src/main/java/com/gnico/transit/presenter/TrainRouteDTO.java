package com.gnico.transit.presenter;

import java.util.List;

import org.locationtech.jts.geom.LineString;
import org.n52.jackson.datatype.jts.GeometrySerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TrainRouteDTO {

	private String uniqueRouteId;
	@JsonSerialize(using = GeometrySerializer.class)
	private LineString path;
	private String line;
	private String branch;
	private String fullName;
	private String headsign;
	private List<TrainStopDTO> stops;
	private final String type = "train";
	
	public TrainRouteDTO() {}

	public String getUniqueRouteId() {
		return uniqueRouteId;
	}

	public void setUniqueRouteId(String uniqueRouteId) {
		this.uniqueRouteId = uniqueRouteId;
	}

	public LineString getPath() {
		return path;
	}

	public void setPath(LineString path) {
		this.path = path;
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

	public List<TrainStopDTO> getStops() {
		return stops;
	}

	public void setStops(List<TrainStopDTO> stops) {
		this.stops = stops;
	}

	public String getType() {
		return type;
	}
	
	
}
