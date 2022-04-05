package com.gnico.transit.interactors;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gnico.transit.domain.TrainRoute;
import com.gnico.transit.usecases.GetRoutesRequest;
import com.gnico.transit.usecases.GetTrainRoutes;
import com.gnico.transit.usecases.GetTrainRoutesResponse;

@Component
public class TrainInfoRetriever implements GetTrainRoutes {

	private TrainDataGateway trainDataGateway;

	public TrainInfoRetriever(TrainDataGateway trainDataGateway) {
		this.trainDataGateway = trainDataGateway;
	}
	
	@Override
	public GetTrainRoutesResponse getTrainRoutes(GetRoutesRequest requestModel) {
		List<TrainRoute> routes = trainDataGateway.findRoutesForLine(requestModel.getLine());
		if (requestModel.isWithStops()) {
			for (TrainRoute route : routes) {
				route.setStops(trainDataGateway.findStopsForLineAndBranch(
						route.getLine(), route.getBranch()));
			}
		}
		return new GetTrainRoutesResponse(requestModel.getLine(), routes);
	}
	
}
