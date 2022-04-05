package com.gnico.transit.usecases;

import com.gnico.transit.domain.SubwayRoute;

public class GetSubwayRouteResponse {

	private String line;
	private SubwayRoute route;
	
	public GetSubwayRouteResponse(String line, SubwayRoute route) {
		this.line = line;
		this.route = route;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public SubwayRoute getRoute() {
		return route;
	}

	public void setRoute(SubwayRoute route) {
		this.route = route;
	}
	
}
