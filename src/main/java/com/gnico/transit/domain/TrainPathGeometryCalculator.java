package com.gnico.transit.domain;

import java.util.List;

import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.MultiPoint;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.operation.distance.DistanceOp;

public class TrainPathGeometryCalculator extends PathGeometryCalculator {
	
	private List<? extends Stop> stops;

	public TrainPathGeometryCalculator(List<? extends Stop> stops) {
		this.stops = stops;
	}
	
	@Override
	public Point getClosestPointOnLineStringFromLocation(LineString path, Point location) {
		Point[] stopLocations = new Point[stops.size()];
		for (int i = 0; i < stops.size(); i++) {
			stopLocations[i] = stops.get(i).getLocation();
		}
		MultiPoint allStopPoints = gf.createMultiPoint(stopLocations);
		Point nearestStop = gf.createPoint(DistanceOp.nearestPoints(allStopPoints, location)[0]);
		MultiPoint accessPoints = gf.createMultiPointFromCoords(path.getCoordinates());
		return gf.createPoint(DistanceOp.nearestPoints(accessPoints, nearestStop)[0]);
	}

	@Override
	public boolean isRightDirection(LineString path, Point startLocation, Point endLocation) {
		return true;
	}

}
