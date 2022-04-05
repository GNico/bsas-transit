package com.gnico.transit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnico.transit.presenter.GetTrainRoutesViewModel;
import com.gnico.transit.presenter.TrainInfoPresenter;
import com.gnico.transit.usecases.GetRoutesRequest;
import com.gnico.transit.usecases.GetTrainRoutes;
import com.gnico.transit.usecases.GetTrainRoutesResponse;

@RestController
@CrossOrigin
public class TrainController {

	@Autowired
	private GetTrainRoutes getTrainRoutesUsecase;
	
	@Autowired
	private TrainInfoPresenter trainInfoPresenter;
	
	@GetMapping("/train/routes")
	public GetTrainRoutesViewModel getTrainRoute(@RequestParam("line") String line,
			@RequestParam(name = "stops", required = false, defaultValue = "false") boolean showStops) {
		GetTrainRoutesResponse response = getTrainRoutesUsecase.getTrainRoutes(
				new GetRoutesRequest(line, showStops));
		return trainInfoPresenter.formatTrainRoutes(response);
		
	} 
}
