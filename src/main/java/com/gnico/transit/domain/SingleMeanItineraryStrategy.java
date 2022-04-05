package com.gnico.transit.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.locationtech.jts.geom.Point;

//finds itineraries without tranfers
public class SingleMeanItineraryStrategy implements ItineraryStrategy {
	
	private RouteFinder routeFinder;
	
	public SingleMeanItineraryStrategy(RouteFinder routeFinder) {
		this.routeFinder = routeFinder;
	}
	
	public List<Itinerary> calculateItineraries(Point startLocation, Point endLocation, double maxDistance) {
		List<Route> startRoutes = routeFinder.findRoutesCloseToLocation(startLocation.getY(), 
				startLocation.getX(), maxDistance);
		List<Route> endRoutes = routeFinder.findRoutesCloseToLocation(endLocation.getY(), 
				endLocation.getX(), maxDistance);
		List<Route> candidateRoutes = matchSameRoutes(startRoutes, endRoutes);
		candidateRoutes = discardWrongDirectionRoutes(candidateRoutes, startLocation, endLocation);
		return buildItineraries(candidateRoutes, startLocation, endLocation);
	}
	
	private List<Route> matchSameRoutes(List<Route> routesCloseToStart, List<Route> routesCloseToEnd) {
		List<Route> result = new ArrayList<>();
		HashSet<String> seenRoutes = new HashSet<>();		
		for (Route startRoute : routesCloseToStart) {
			seenRoutes.add(startRoute.getUniqueId());
		}
		for (Route endRoute : routesCloseToEnd) {
			if (seenRoutes.contains(endRoute.getUniqueId())) {
				result.add(endRoute);
			}
		}
		return result;
	}

	private List<Route> discardWrongDirectionRoutes(List<Route> routes, 
			Point startLocation, Point endLocation) {
		List<Route> rightDirectionRoutes = new ArrayList<>();
		for (Route route : routes) {
			if (route.isRightDirection(startLocation, endLocation)) {
				rightDirectionRoutes.add(route);
			}
		}
		return rightDirectionRoutes;
	}

	private List<Itinerary> buildItineraries(List<Route> routes, Point startLocation, Point endLocation) {
		List<Itinerary> itineraries = new ArrayList<>();
		for (Route route : routes) {
			Itinerary itinerary = Itinerary.create(startLocation, endLocation, route);
			itineraries.add(itinerary);
		}
		return itineraries;
	}
	
}
