package com.gnico.transit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnico.transit.presenter.GetTrainRoutesViewModel;
import com.gnico.transit.presenter.TrainInfoPresenter;
import com.gnico.transit.usecases.GetRoutesRequest;
import com.gnico.transit.usecases.GetTrainRoutes;
import com.gnico.transit.usecases.GetTrainRoutesResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

@RestController
@CrossOrigin
class TrainController {

	@Autowired
	private GetTrainRoutes getTrainRoutesUsecase;
	
	@Autowired
	private TrainInfoPresenter trainInfoPresenter;
	
	@GetMapping("/train/routes/{line}")
	@Operation(tags="3. Train routes", summary = "Get all train routes from a line")
	@Parameter(in = ParameterIn.QUERY, name="stops", description="Retrieve info of the stops for each route")
	public GetTrainRoutesViewModel getTrainRoute(@PathVariable String line,
			@RequestParam(name = "stops", required = false, defaultValue = "false") boolean showStops) {
		GetTrainRoutesResponse response = getTrainRoutesUsecase.getTrainRoutes(
				new GetRoutesRequest(line, showStops));
		return trainInfoPresenter.formatTrainRoutes(response);
		
	} 
}
