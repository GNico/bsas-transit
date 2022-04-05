package com.gnico.transit.domain;

import org.locationtech.jts.geom.Point;

public class BusStop {
	
	private long code;
	private String name;
	private Point location;
	
	public BusStop() {}
	
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
