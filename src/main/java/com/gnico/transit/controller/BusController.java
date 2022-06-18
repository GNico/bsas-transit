package com.gnico.transit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnico.transit.presenter.BusInfoPresenter;
import com.gnico.transit.presenter.GetBusRoutesViewModel;
import com.gnico.transit.usecases.GetBusRoutes;
import com.gnico.transit.usecases.GetBusRoutesResponse;
import com.gnico.transit.usecases.GetRoutesRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin
class BusController {
	
	@Autowired
	private GetBusRoutes getBusRoutesUsecase;
	
	@Autowired
	private BusInfoPresenter busInfoPresenter;
	
	
	@GetMapping("/bus/routes/{line}")
	@Operation(tags="1. Bus routes", summary = "Get all bus routes from a line")
	@Parameter(in = ParameterIn.QUERY, name="stops", description="Retrieve info of the stops for each route")
	@ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json") })
	public GetBusRoutesViewModel getBusRoute(@PathVariable String line,
			@RequestParam(name = "stops", required = false, defaultValue = "false") boolean showStops) {
		GetBusRoutesResponse response = getBusRoutesUsecase.getBusRoutes(
				new GetRoutesRequest(line, showStops));
		return busInfoPresenter.formatBusRoutes(response);
		
	} 
		
}
