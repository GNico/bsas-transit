package com.gnico.transit.presenter;

import java.util.List;

public class GetTrainRoutesViewModel {

	private String line;
	private List<TrainRouteDTO> routes;
	
	public GetTrainRoutesViewModel(String line, List<TrainRouteDTO> routes) {
		this.line = line;
		this.routes = routes;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public List<TrainRouteDTO> getRoutes() {
		return routes;
	}
	public void setRoutes(List<TrainRouteDTO> routes) {
		this.routes = routes;
	}
}
