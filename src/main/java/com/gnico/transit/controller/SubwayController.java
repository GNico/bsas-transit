package com.gnico.transit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnico.transit.presenter.GetSubwayRouteViewModel;
import com.gnico.transit.presenter.SubwayInfoPresenter;
import com.gnico.transit.usecases.GetRoutesRequest;
import com.gnico.transit.usecases.GetSubwayRoute;
import com.gnico.transit.usecases.GetSubwayRouteResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

@RestController
@CrossOrigin
class SubwayController {

	@Autowired
	private GetSubwayRoute getSubwayRouteUsecase;
	
	@Autowired
	private SubwayInfoPresenter subwayInfoPresenter;
	
	@GetMapping("/subway/routes/{line}")
	@Operation(tags="2. Subway routes", summary = "Get all subway routes from a line")
	@Parameter(in = ParameterIn.QUERY, name="stops", description="Retrieve info of the stops for each route")
	public GetSubwayRouteViewModel getSubwayRoute(@PathVariable String line,
			@RequestParam(name = "stops", required = false, defaultValue = "false") boolean showStops) {
		GetSubwayRouteResponse response = getSubwayRouteUsecase.getRoute(
				new GetRoutesRequest(line, showStops));
		return subwayInfoPresenter.formatSubwayRoutes(response);
		
	} 
	
	
}
