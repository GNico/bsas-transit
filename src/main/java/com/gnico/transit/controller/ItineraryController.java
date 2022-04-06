package com.gnico.transit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnico.transit.presenter.FindItineraryViewModel;
import com.gnico.transit.presenter.ItineraryPresenter;
import com.gnico.transit.usecases.FindItinerary;
import com.gnico.transit.usecases.FindItineraryRequest;
import com.gnico.transit.usecases.FindItineraryResponse;
import com.gnico.transit.utils.DistanceConverter;

@RestController
@CrossOrigin
class ItineraryController {
	
	@Autowired
	private FindItinerary itineraryFinderUsercase;
	
	@Autowired
	private ItineraryPresenter itineraryPresenter;
	
	@GetMapping("/itinerary")
	public FindItineraryViewModel findItineraries(
			@RequestParam("startLat") double startLat,
			@RequestParam("startLon") double startLon,
			@RequestParam("endLat") double endLat,
			@RequestParam("endLon") double endLon,
			@RequestParam("distance") int distance) {	
		FindItineraryResponse response = itineraryFinderUsercase.findItinerary(new FindItineraryRequest(
				startLat, startLon, endLat, endLon, DistanceConverter.metersToDegree(distance)));
		
		return itineraryPresenter.formatResponse(response);
	}
}
