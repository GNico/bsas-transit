package com.gnico.transit.usecases;

import java.util.List;

import com.gnico.transit.domain.BusRoute;

public class GetBusRoutesResponse {

	private String line;
	private List<BusRoute> routes;
	
	public GetBusRoutesResponse(String line, List<BusRoute> routes) {
		this.line = line;
		this.routes = routes;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public List<BusRoute> getRoutes() {
		return routes;
	}

	public void setRoutes(List<BusRoute> routes) {
		this.routes = routes;
	}
	
	
	
	
}
