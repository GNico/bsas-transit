package com.gnico.transit.presenter;

import org.locationtech.jts.geom.Point;
import org.n52.jackson.datatype.jts.GeometrySerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class SubwayStopDTO {

	private String name;
	@JsonSerialize(using = GeometrySerializer.class)
	private Point location;
	private String line;
	
	public SubwayStopDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}
	
}
