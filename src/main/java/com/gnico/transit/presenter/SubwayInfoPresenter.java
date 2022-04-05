package com.gnico.transit.presenter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gnico.transit.domain.SubwayRoute;
import com.gnico.transit.domain.SubwayStop;
import com.gnico.transit.usecases.GetSubwayRouteResponse;

@Mapper(componentModel = "spring")
public interface SubwayInfoPresenter {

	GetSubwayRouteViewModel formatSubwayRoutes(GetSubwayRouteResponse source);
	
	@Mapping(target="uniqueRouteId", expression = "java(source.getUniqueId())")
	SubwayRouteDTO subwayRouteToSubwayRouteDTO(SubwayRoute source);
	
	SubwayStopDTO subwayStopToSubwayStopDTO(SubwayStop source);
}
