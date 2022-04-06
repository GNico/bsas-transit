package com.gnico.transit.interactors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gnico.transit.domain.BusRoute;
import com.gnico.transit.domain.Route;
import com.gnico.transit.domain.RouteFinder;
import com.gnico.transit.domain.SubwayRoute;

@Service
class AllMeansRouteFinder implements RouteFinder {

	private BusDataGateway busDataGateway;
	private SubwayDataGateway subwayDataGateway;

	public AllMeansRouteFinder(BusDataGateway busDataGateway, SubwayDataGateway subwayDataGateway) {
		this.busDataGateway = busDataGateway;
		this.subwayDataGateway = subwayDataGateway;
	}

	@Override
	public List<Route> findRoutesCloseToLocation(double lat, double lon, double maxDistance) {
		List<Route> routes = new ArrayList<>();
		List<BusRoute> busRoutes = busDataGateway.findRoutesCloseToLocation(lat, lon, maxDistance);
		for (Route busRoute : busRoutes) {
			routes.add(busRoute);
		}
		List<SubwayRoute> subwayRoutes = subwayDataGateway.findRoutesCloseToLocation(lat, lon, maxDistance);
		for (SubwayRoute subwayRoute : subwayRoutes) {
			routes.add(subwayRoute);
		}
		return routes;
	}

	
}
