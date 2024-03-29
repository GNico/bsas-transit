package com.gnico.transit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnico.transit.usecases.GetAllLines;
import com.gnico.transit.usecases.GetAllLinesResponse;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
class LinesController {

	@Autowired
	private GetAllLines getLinesUsecase;
	
	
	@GetMapping("/lines")
	@Operation(tags="5. Lines", summary = "Get all the lines close to a location")
	public GetAllLinesResponse getLines(
			@RequestParam(name = "lat", required = false) Double lat,
			@RequestParam(name = "lon", required = false) Double lon) {
		
		return (lat != null && lon != null) 
				? getLinesUsecase.getLinesCloseTo(lat, lon) 
				: getLinesUsecase.getAllLines();
	}
	
}
