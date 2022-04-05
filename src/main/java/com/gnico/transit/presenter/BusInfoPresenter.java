package com.gnico.transit.presenter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gnico.transit.domain.BusRoute;
import com.gnico.transit.domain.BusStop;
import com.gnico.transit.usecases.GetBusRoutesResponse;

@Mapper(componentModel = "spring")
public interface BusInfoPresenter {

	GetBusRoutesViewModel formatBusRoutes(GetBusRoutesResponse source);
	
	@Mapping(target="uniqueRouteId", expression = "java(value.getUniqueId())")
	BusRouteDTO busRouteToBusRouteDTO(BusRoute value);
	
    BusStopDTO busStopToBusStopDTO(BusStop value);
	

	
}
