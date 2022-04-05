package com.gnico.transit.database.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.locationtech.jts.geom.LineString;

@Entity
@Table(name = "subway_routes")
public class SubwayRouteTableRow {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "linea")
	private String line;
	
	@Column(name = "route_geom")
	private LineString geom;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "description")
	private String name;
	
	@Transient
	private List<SubwayStopTableRow> stops;

	public SubwayRouteTableRow() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public LineString getGeom() {
		return geom;
	}

	public void setGeom(LineString geom) {
		this.geom = geom;
	}

	public List<SubwayStopTableRow> getStops() {
		return stops;
	}

	public void setStops(List<SubwayStopTableRow> stops) {
		this.stops = stops;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

