package com.gnico.transit.presenter;

import java.util.List;

import org.locationtech.jts.geom.LineString;
import org.n52.jackson.datatype.jts.GeometrySerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class SubwayRouteDTO {

	private String uniqueRouteId;
	@JsonSerialize(using = GeometrySerializer.class)
	private LineString path;
	private String line;
	private List<SubwayStopDTO> stops;
	private String color;
	private String name;
	private final String type = "subway";
	
	public SubwayRouteDTO() {}

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

	public List<SubwayStopDTO> getStops() {
		return stops;
	}

	public void setStops(List<SubwayStopDTO> stops) {
		this.stops = stops;
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

	public String getType() {
		return type;
	}
	

	

}
