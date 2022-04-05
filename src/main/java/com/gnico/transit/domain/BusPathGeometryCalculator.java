package com.gnico.transit.domain;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.MultiPoint;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.operation.distance.DistanceOp;

public class BusPathGeometryCalculator extends PathGeometryCalculator {

	@Override
	public Point getClosestPointOnLineStringFromLocation(LineString path, Point location) {
		MultiPoint accessPoints = gf.createMultiPointFromCoords(path.getCoordinates());
		return gf.createPoint(DistanceOp.nearestPoints(accessPoints, location)[0]);
	}

	@Override
	public boolean isRightDirection(LineString path, Point startLocation, Point endLocation) {
		Point routeStartLocation = getClosestPointOnLineStringFromLocation(path, startLocation);
		Point routeEndLocation = getClosestPointOnLineStringFromLocation(path, endLocation);
		boolean foundStart = false;
		boolean foundEnd = false;
		boolean rightDirection = true;
		for (Coordinate coord : path.getCoordinates()) {
			foundStart = foundStart || (coord.compareTo(routeStartLocation.getCoordinate()) == 0);
			foundEnd = (coord.compareTo(routeEndLocation.getCoordinate()) == 0);
			if (foundEnd) {
				rightDirection = foundStart;
				break;
			}
		}
		return rightDirection;
	}

}
