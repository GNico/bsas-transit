package com.gnico.transit.presenter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gnico.transit.domain.TrainRoute;
import com.gnico.transit.domain.TrainStop;
import com.gnico.transit.usecases.GetTrainRoutesResponse;

@Mapper(componentModel = "spring")
public interface TrainInfoPresenter {

	GetTrainRoutesViewModel formatTrainRoutes(GetTrainRoutesResponse source);
	
	@Mapping(target="uniqueRouteId", expression = "java(value.getUniqueId())")
	TrainRouteDTO trainRouteToTrainRouteDTO(TrainRoute value);
	
	TrainStopDTO trainStopToTrainStopDTO(TrainStop value);
}
