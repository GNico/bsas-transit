package com.gnico.transit.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.locationtech.jts.geom.Point;
import org.n52.jackson.datatype.jts.GeometryDeserializer;
import org.n52.jackson.datatype.jts.GeometrySerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name= "bus_stops_test")
public class BusStopTableRow {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "stop_code")
	private Long code;
	
	@Column(name = "stop_name")
	private String name;
	
	@Column(name = "direction_id")
	private Short direction;
	
	@Column(name = "route_id")
	private Integer routeId;
	
	@Column(name = "stop_geom")
	@JsonSerialize(using = GeometrySerializer.class)
	@JsonDeserialize(using = GeometryDeserializer.class)
	private Point geom;
	
	public BusStopTableRow() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getDirection() {
		return direction;
	}

	public void setDirection(Short direction) {
		this.direction = direction;
	}

	public Integer getRoute() {
		return routeId;
	}

	public void setRoute(Integer routeId) {
		this.routeId = routeId;
	}

	public Point getGeom() {
		return geom;
	}

	public void setGeom(Point geom) {
		this.geom = geom;
	}
	
	
}
