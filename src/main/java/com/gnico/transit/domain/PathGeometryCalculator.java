package com.gnico.transit.domain;

import java.util.Arrays;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

public abstract class PathGeometryCalculator {

	protected final GeometryFactory gf = new GeometryFactory();

	public abstract Point getClosestPointOnLineStringFromLocation(LineString path, Point location);
	
	public abstract boolean isRightDirection(LineString path, Point startLocation, Point endLocation);
	
	public LineString getLineStringBetweenPoints(LineString path, Point startLocation, Point endLocation) {
		Coordinate routeStartLocation = getClosestPointOnLineStringFromLocation(path, startLocation).getCoordinate();
		Coordinate routeEndLocation = getClosestPointOnLineStringFromLocation(path, endLocation).getCoordinate();
		int startIndex = -1;
		int endIndex = -1;
		boolean shouldReverse = false;
		Coordinate[] routeCoords = path.getCoordinates();
		for (int i=0; i < routeCoords.length ; i++) {
			Coordinate coord = routeCoords[i];
			if (startIndex < 0 && coord.compareTo(routeStartLocation) == 0)
				startIndex = i;
			if (coord.compareTo(routeEndLocation) == 0) {
				endIndex = i;
				if (startIndex < 0) 
					shouldReverse = true;
			}
			if (startIndex > -1 && endIndex > -1) 
				break;
		}
		return shouldReverse 
				? gf.createLineString(Arrays.copyOfRange(routeCoords, endIndex, startIndex+1)).reverse() 
				: gf.createLineString(Arrays.copyOfRange(routeCoords, startIndex, endIndex+1));
	}
}
