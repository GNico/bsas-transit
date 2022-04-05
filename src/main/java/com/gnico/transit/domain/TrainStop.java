package com.gnico.transit.domain;

import org.locationtech.jts.geom.Point;

public class TrainStop implements Stop {

	private String name;
	private String line;
	private String branch;
	private Point location;
	
	public TrainStop() {}
	
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}
	
	
}
