package com.gnico.transit.domain;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

public class LocationFactory {
	
	private LocationFactory() {}

	public static Point create(double lat, double lon) {
		GeometryFactory gf = new GeometryFactory();
		return gf.createPoint(new Coordinate(lon, lat));
	}
		
}
