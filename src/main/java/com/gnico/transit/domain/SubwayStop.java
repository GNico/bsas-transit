package com.gnico.transit.domain;

import org.locationtech.jts.geom.Point;

public class SubwayStop implements Stop {
	
	private String name;
	private String line;
	private Point location;
	
	public SubwayStop() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	@Override
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	
}
