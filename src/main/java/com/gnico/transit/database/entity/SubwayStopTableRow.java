package com.gnico.transit.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "subway_stops")
public class SubwayStopTableRow {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "linea")
	private String line;
	
	@Column(name = "stop_geom")
	private Point geom;
	
	public SubwayStopTableRow() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public Point getGeom() {
		return geom;
	}

	public void setGeom(Point geom) {
		this.geom = geom;
	}
	
	
	
	
	
}
