package com.gnico.transit.interactors;

import org.springframework.stereotype.Component;

import com.gnico.transit.domain.SubwayRoute;
import com.gnico.transit.usecases.GetRoutesRequest;
import com.gnico.transit.usecases.GetSubwayRoute;
import com.gnico.transit.usecases.GetSubwayRouteResponse;

@Component
class SubwayInfoRetriever implements GetSubwayRoute  {

	private SubwayDataGateway subwayDataGateway;
	
	public SubwayInfoRetriever(SubwayDataGateway subwayDataGateway) {
		this.subwayDataGateway = subwayDataGateway;
	}

	@Override
	public GetSubwayRouteResponse getRoute(GetRoutesRequest requestModel) {
		SubwayRoute route = subwayDataGateway.findRouteForLine(requestModel.getLine());
		return new GetSubwayRouteResponse(requestModel.getLine(), route);
	}

}
