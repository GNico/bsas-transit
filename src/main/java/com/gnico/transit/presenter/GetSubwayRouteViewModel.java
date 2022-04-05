package com.gnico.transit.presenter;

public class GetSubwayRouteViewModel {

	private String line;
	private SubwayRouteDTO route;
	
	public GetSubwayRouteViewModel(String line, SubwayRouteDTO route) {
		this.line = line;
		this.route = route;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public SubwayRouteDTO getRoute() {
		return route;
	}
	public void setRoute(SubwayRouteDTO route) {
		this.route = route;
	}
	
	
}
