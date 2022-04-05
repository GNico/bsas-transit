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
@Table(name = "train_routes")
public class TrainRouteTableRow {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "linea")
	private String line;
	
	@Column(name = "route_geom")
	private LineString geom;
	
	@Column(name = "ramal")
	private String branch;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "trip_headsign")
	private String headsign;
	
	@Transient
	private List<TrainStopTableRow> stops;

	public TrainRouteTableRow() {}
	
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getHeadsign() {
		return headsign;
	}

	public void setHeadsign(String headsign) {
		this.headsign = headsign;
	}

	public List<TrainStopTableRow> getStops() {
		return stops;
	}

	public void setStops(List<TrainStopTableRow> stops) {
		this.stops = stops;
	}
	
	
}
