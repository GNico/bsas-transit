package com.gnico.transit.geom;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

class GeomTest {

	@Test
	void testDistance() {
		GeometryFactory gf = new GeometryFactory();
		Point p1 = gf.createPoint(new Coordinate(-34.54382778811204, -58.51053165813253));
		//Point p2 = gf.createPoint(new Coordinate(-34.54150519219668, -58.50615538706797));
		
		LineString line = gf.createLineString(new Coordinate[] {
			new Coordinate(-34.535492991105016, -58.51288362504133),
			new Coordinate(-34.548009694765376, -58.5013103371782),
			new Coordinate(-34.5415332633269, -58.48660077664986),
		});
		
		for (Coordinate coord : line.getCoordinates()) {
			System.out.println(p1.distance(gf.createPoint(coord)));
		}
		
		System.out.println("Distance");
		System.out.println(p1.distance(line));
		assertTrue(true);
	}

}
