package com.gnico.transit.domain;

import java.util.List;

public interface RouteFinder  {

	List<Route> findRoutesCloseToLocation(double lat, double lon, double maxDistance);

}
