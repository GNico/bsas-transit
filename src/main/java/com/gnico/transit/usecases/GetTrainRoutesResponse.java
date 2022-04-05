package com.gnico.transit.usecases;

import java.util.List;

import com.gnico.transit.domain.TrainRoute;

public class GetTrainRoutesResponse {

	private String line;
	private List<TrainRoute> routes;
	
	public GetTrainRoutesResponse(String line, List<TrainRoute> routes) {
		this.line = line;
		this.routes = routes;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public List<TrainRoute> getRoutes() {
		return routes;
	}
	public void setRoutes(List<TrainRoute> routes) {
		this.routes = routes;
	}
	
	
}
