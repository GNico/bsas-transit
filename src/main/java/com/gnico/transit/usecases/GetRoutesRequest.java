package com.gnico.transit.usecases;

public class GetRoutesRequest {

	private String line;
	private boolean withStops;
	
	public GetRoutesRequest(String line, boolean withStops) {
		this.line = line;
		this.withStops = withStops;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public boolean isWithStops() {
		return withStops;
	}
	public void setWithStops(boolean withStops) {
		this.withStops = withStops;
	}
	
}
