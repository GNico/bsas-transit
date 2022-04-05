package com.gnico.transit.domain;

import java.util.List;

public class BusLine {

	private String name;
	private String agency;
	private List<BusRoute> routes;
	
	public BusLine() {};
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public List<BusRoute> getRoutes() {
		return routes;
	}
	public void setRoutes(List<BusRoute> routes) {
		this.routes = routes;
	}
	
	
	
}
