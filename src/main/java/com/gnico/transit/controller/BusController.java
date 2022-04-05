package com.gnico.transit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnico.transit.presenter.BusInfoPresenter;
import com.gnico.transit.presenter.GetBusRoutesViewModel;
import com.gnico.transit.usecases.GetBusRoutes;
import com.gnico.transit.usecases.GetBusRoutesResponse;
import com.gnico.transit.usecases.GetRoutesRequest;

@RestController
@CrossOrigin
public class BusController {
	
	@Autowired
	private GetBusRoutes getBusRoutesUsecase;
	
	@Autowired
	private BusInfoPresenter busInfoPresenter;
	
	
	@GetMapping("/bus/routes")
	public GetBusRoutesViewModel getBusRoute(@RequestParam("line") String line,
			@RequestParam(name = "stops", required = false, defaultValue = "false") boolean showStops) {
		GetBusRoutesResponse response = getBusRoutesUsecase.getBusRoutes(
				new GetRoutesRequest(line, showStops));
		return busInfoPresenter.formatBusRoutes(response);
		
	} 
		
}
