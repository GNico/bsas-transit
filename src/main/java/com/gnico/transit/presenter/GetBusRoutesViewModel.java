package com.gnico.transit.presenter;

import java.util.List;

public class GetBusRoutesViewModel {

	private String line;
	private List<BusRouteDTO> routes;
	
	public GetBusRoutesViewModel(String line, List<BusRouteDTO> routes) {
		this.line = line;
		this.routes = routes;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public List<BusRouteDTO> getRoutes() {
		return routes;
	}

	public void setRoutes(List<BusRouteDTO> routes) {
		this.routes = routes;
	}
}
