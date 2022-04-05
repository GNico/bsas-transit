package com.gnico.transit.presenter;

import java.util.List;

import org.locationtech.jts.geom.Point;
import org.n52.jackson.datatype.jts.GeometrySerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ItineraryDTO {
	@JsonSerialize(using = GeometrySerializer.class)
	private Point startLocation;
	@JsonSerialize(using = GeometrySerializer.class)
	private Point endLocation;
	private List<ItineraryStepDTO> steps;
	private double cost;
	
	public ItineraryDTO() {}
	
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
	public List<ItineraryStepDTO> getSteps() {
		return steps;
	}
	public void setSteps(List<ItineraryStepDTO> steps) {
		this.steps = steps;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
}
