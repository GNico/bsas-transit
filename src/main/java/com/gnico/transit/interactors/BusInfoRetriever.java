package com.gnico.transit.interactors;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gnico.transit.domain.BusRoute;
import com.gnico.transit.usecases.GetBusRoutes;
import com.gnico.transit.usecases.GetBusRoutesResponse;
import com.gnico.transit.usecases.GetRoutesRequest;

@Component
class BusInfoRetriever implements  GetBusRoutes {
	
	private BusDataGateway busDataGateway;
	
	public BusInfoRetriever(BusDataGateway busDataGateway) {
		this.busDataGateway = busDataGateway;
	}

	@Override
	public GetBusRoutesResponse getBusRoutes(GetRoutesRequest requestModel) {
		List<BusRoute> routes = busDataGateway.findRoutesForLine(requestModel.getLine());
		if (requestModel.isWithStops()) {
			for (BusRoute route : routes) {
				route.setStops(busDataGateway.findStopsForRouteAndDirection(
						route.getRouteId(), route.isReturnDirection()));
			}
		}
		return new GetBusRoutesResponse(requestModel.getLine(), routes);
	}

}
