package com.gnico.transit.usecases;

import java.util.List;

import com.gnico.transit.domain.Itinerary;

public class FindItineraryResponse {
	
private List<Itinerary> itineraries;
	
	public FindItineraryResponse() {}
	
	public FindItineraryResponse(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}

	public List<Itinerary> getItineraries() {
		return itineraries;
	}

	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}

}
