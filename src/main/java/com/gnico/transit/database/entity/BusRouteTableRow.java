package com.gnico.transit.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.locationtech.jts.geom.LineString;

@Entity
@Table(name = "bus_routes")
public class BusRouteTableRow {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "route_id")
	private Integer routeId;
	
	@Column(name = "direction_id")
	private Short direction;
	
	@Column(name = "route_geom")
	private LineString geom;
	
	@Column(name = "route_short_name")
	private String shortName;
	
	@Column(name = "long_short_name")
	private String longName;
	
	@Column(name = "route_desc")
	private String description;
	
	@Column(name = "trip_id")
	private String tripId;
	
	@Column(name = "trip_headsign")
	private String tripHeadsign;
	
	@Column(name = "linea")
	private String linea;
	
	@Column(name = "ramal")
	private String ramal;
	
	public BusRouteTableRow() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Short getDirection() {
		return direction;
	}

	public void setDirection(Short direction) {
		this.direction = direction;
	}

	public LineString getGeom() {
		return geom;
	}

	public void setGeom(LineString geom) {
		this.geom = geom;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getTripHeadsign() {
		return tripHeadsign;
	}

	public void setTripHeadsign(String tripHeadsign) {
		this.tripHeadsign = tripHeadsign;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	
}
