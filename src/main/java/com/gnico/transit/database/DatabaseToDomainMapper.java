package com.gnico.transit.database;

import java.util.List;

import org.locationtech.jts.geom.LineString;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gnico.transit.database.entity.BusRouteTableRow;
import com.gnico.transit.database.entity.BusStopTableRow;
import com.gnico.transit.database.entity.SubwayRouteTableRow;
import com.gnico.transit.database.entity.SubwayStopTableRow;
import com.gnico.transit.database.entity.TrainRouteTableRow;
import com.gnico.transit.database.entity.TrainStopTableRow;
import com.gnico.transit.domain.BusPathGeometryCalculator;
import com.gnico.transit.domain.BusRoute;
import com.gnico.transit.domain.BusStop;
import com.gnico.transit.domain.PathGeometryCalculator;
import com.gnico.transit.domain.SubwayRoute;
import com.gnico.transit.domain.SubwayStop;
import com.gnico.transit.domain.TrainPathGeometryCalculator;
import com.gnico.transit.domain.TrainRoute;
import com.gnico.transit.domain.TrainStop;

@Mapper(componentModel = "spring", imports = { BusPathGeometryCalculator.class, 
		TrainPathGeometryCalculator.class } )
interface DatabaseToDomainMapper {
	
	default boolean map(Short val) {
		return val != 0;
	}

	List<BusRoute> busRouteTableToBusRouteEntityList(List<BusRouteTableRow> source);
		
	@Mapping(target="line", source="linea")
	@Mapping(target="branch", source="ramal")
	@Mapping(target="returnDirection", source="direction")
	@Mapping(target="path", source="geom")
	@Mapping(target="tripSign", source="tripHeadsign")
	@Mapping(target="stops", ignore=true)
	@Mapping(target="pathGeomCalculator", expression = "java(new BusPathGeometryCalculator())")
	BusRoute busRouteTableToBusRouteEntity(BusRouteTableRow source);
	
	List<BusStop> busStopTableToBusStopEntityList(List<BusStopTableRow> source);
	
	@Mapping(target="location", source="geom")
	BusStop busStopTableToBusStopEntity(BusStopTableRow source);
	
	
	//subway
	
	List<SubwayRoute> subwayRouteTableToSubwayEntityList(List<SubwayRouteTableRow> source);

	default SubwayRoute subwayRouteTableToSubwayEntity(SubwayRouteTableRow source) {
		if (source == null) 
			return null;
        LineString path = null;
	    String line = null;
	    String color = null;
	    String name = null;
        path = source.getGeom();
        line = source.getLine();
        color = source.getColor();
        name = source.getName();
        List<SubwayStop> stops = subwayStopTableToSubwayStopEntityList(source.getStops());
        PathGeometryCalculator pathGeomCalculator = new TrainPathGeometryCalculator(stops);
        return new SubwayRoute( line, stops, path, color, name, pathGeomCalculator );
	}
	
	List<SubwayStop> subwayStopTableToSubwayStopEntityList(List<SubwayStopTableRow> stop);

	@Mapping(target="location", source="geom")
	SubwayStop subwayStopTableToSubwayStopEntity(SubwayStopTableRow stop);
	
	
	//train
	
	List<TrainRoute> trainRouteTableToTrainEntityList(List<TrainRouteTableRow> source);

	default TrainRoute trainRouteTableToTrainEntity(TrainRouteTableRow source) {
		if (source == null) 
			return null;
        LineString path = null;
	    String line = null;
	    String branch = null;
	    String headsign = null;
	    String fullName = null;
        path = source.getGeom();
        line = source.getLine();
        branch = source.getBranch();
        headsign = source.getHeadsign();
        fullName = source.getFullName();
        List<TrainStop> stops = trainStopTableToTrainStopEntityList(source.getStops());
        PathGeometryCalculator pathGeomCalculator = new TrainPathGeometryCalculator(stops);
        return new TrainRoute( line, branch, fullName, headsign, path, pathGeomCalculator, stops );
	}
	
	List<TrainStop> trainStopTableToTrainStopEntityList(List<TrainStopTableRow> stop);

	@Mapping(target="location", source="geom")
	TrainStop trainStopTableToTrainStopEntity(TrainStopTableRow stop);
	
	
}
