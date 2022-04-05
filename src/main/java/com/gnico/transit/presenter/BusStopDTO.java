package com.gnico.transit.presenter;

import org.locationtech.jts.geom.Point;
import org.n52.jackson.datatype.jts.GeometrySerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class BusStopDTO {

	private long code;
	private String name;
	@JsonSerialize(using = GeometrySerializer.class)
	private Point location;
	
	public BusStopDTO() {}
	
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
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
}
