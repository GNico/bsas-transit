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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

@RestController
@CrossOrigin
class ItineraryController {
	
	@Autowired
	private FindItinerary itineraryFinderUsercase;
	
	@Autowired
	private ItineraryPresenter itineraryPresenter;
	
	@GetMapping("/itinerary")
	@Operation(tags="4. Itinerary", summary = "Get the most convenient route between two locations")
	@Parameter(in = ParameterIn.QUERY, name="distance", description="Maximum distance from location to routes in meters")
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
