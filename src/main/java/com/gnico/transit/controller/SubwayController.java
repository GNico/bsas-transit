package com.gnico.transit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnico.transit.presenter.GetSubwayRouteViewModel;
import com.gnico.transit.presenter.SubwayInfoPresenter;
import com.gnico.transit.usecases.GetRoutesRequest;
import com.gnico.transit.usecases.GetSubwayRoute;
import com.gnico.transit.usecases.GetSubwayRouteResponse;

@RestController
@CrossOrigin
class SubwayController {

	@Autowired
	private GetSubwayRoute getSubwayRouteUsecase;
	
	@Autowired
	private SubwayInfoPresenter subwayInfoPresenter;
	
	@GetMapping("/subway/routes")
	public GetSubwayRouteViewModel getBusRoute(@RequestParam("line") String line,
			@RequestParam(name = "stops", required = false, defaultValue = "false") boolean showStops) {
		GetSubwayRouteResponse response = getSubwayRouteUsecase.getRoute(
				new GetRoutesRequest(line, showStops));
		return subwayInfoPresenter.formatSubwayRoutes(response);
		
	} 
	
	
}
