package com.gnico.transit.interactors;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gnico.transit.domain.Itinerary;
import com.gnico.transit.domain.ItineraryStrategy;
import com.gnico.transit.domain.LocationFactory;
import com.gnico.transit.usecases.FindItinerary;
import com.gnico.transit.usecases.FindItineraryRequest;
import com.gnico.transit.usecases.FindItineraryResponse;

@Service
public class ItineraryFinder implements FindItinerary {

	private final ItineraryStrategy itineraryStrategy;
	
	public ItineraryFinder(ItineraryStrategy itineraryStrategy) {
		this.itineraryStrategy = itineraryStrategy;
	}
	
	@Override
	public FindItineraryResponse findItinerary(FindItineraryRequest requestModel) {		
		List<Itinerary> itineraries = itineraryStrategy.calculateItineraries(
				LocationFactory.create(requestModel.getStartLat(), requestModel.getStartLon()), 
				LocationFactory.create(requestModel.getEndLat(), requestModel.getEndLon()), 
				requestModel.getDistance());

		Collections.sort(itineraries, Comparator.comparingDouble(Itinerary::getCost));		
		
		return new FindItineraryResponse(itineraries);
	}
	
	
	
	
	
}
