package com.gnico.transit.presenter;

import org.locationtech.jts.geom.Point;
import org.n52.jackson.datatype.jts.GeometrySerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TrainStopDTO {

	private String name;
	@JsonSerialize(using = GeometrySerializer.class)
	private Point location;
	private String line;
	private String branch;
	
	public TrainStopDTO() {}

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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	

}
