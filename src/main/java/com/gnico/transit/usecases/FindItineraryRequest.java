package com.gnico.transit.usecases;

public class FindItineraryRequest {
	
	private double startLat;
	private double startLon;
	private double endLat;
	private double endLon;
	private double distance;
	
	public FindItineraryRequest(double startLat, double startLon, double endLat, double endLon, double d) {
		this.startLat = startLat;
		this.startLon = startLon;
		this.endLat = endLat;
		this.endLon = endLon;
		this.distance = d;
	}

	public double getStartLat() {
		return startLat;
	}

	public void setStartLat(double startLat) {
		this.startLat = startLat;
	}

	public double getStartLon() {
		return startLon;
	}

	public void setStartLon(double startLon) {
		this.startLon = startLon;
	}

	public double getEndLat() {
		return endLat;
	}

	public void setEndLat(double endLat) {
		this.endLat = endLat;
	}

	public double getEndLon() {
		return endLon;
	}

	public void setEndLon(double endLon) {
		this.endLon = endLon;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	
	
	
	
}
