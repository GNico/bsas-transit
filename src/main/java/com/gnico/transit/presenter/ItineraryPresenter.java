package com.gnico.transit.presenter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gnico.transit.domain.Itinerary;
import com.gnico.transit.domain.ItineraryStep;
import com.gnico.transit.domain.ItineraryStepOnBus;
import com.gnico.transit.domain.ItineraryStepOnFoot;
import com.gnico.transit.domain.ItineraryStepOnSubway;
import com.gnico.transit.usecases.FindItineraryResponse;
import com.gnico.transit.utils.DistanceConverter;

@Mapper(componentModel = "spring", uses = {SubwayInfoPresenter.class, BusInfoPresenter.class}, 
	imports = DistanceConverter.class)
public interface ItineraryPresenter {

	FindItineraryViewModel formatResponse(FindItineraryResponse source);

	@Mapping(target="cost", expression = "java(source.getCost())")
	ItineraryDTO itineraryToItineraryDTO(Itinerary source);
	
	default ItineraryStepDTO formatItineraryStep(ItineraryStep source) {
		if (source instanceof ItineraryStepOnBus) 
			return stepOnBusToStep((ItineraryStepOnBus) source);
		if (source instanceof ItineraryStepOnFoot)
			return stepOnFootToStep((ItineraryStepOnFoot) source);
		if (source instanceof ItineraryStepOnSubway)
			return stepOnSubwayToStep((ItineraryStepOnSubway) source);
		return null;
	}
	
	@Mapping(target = "type", constant="foot")
	@Mapping(target = "travelDistance" , expression = "java(DistanceConverter.degreeToMeters(source.getTravelDistance()))")
	@Mapping(target = "busRoute" , ignore = true)
	@Mapping(target = "subwayRoute" , ignore = true)
	ItineraryStepDTO stepOnFootToStep(ItineraryStepOnFoot source);
	
	@Mapping(target = "type", constant="bus")
	@Mapping(target = "travelDistance" , expression = "java(DistanceConverter.degreeToMeters(source.getTravelDistance()))")
	@Mapping(target = "subwayRoute" , ignore = true)
	ItineraryStepDTO stepOnBusToStep(ItineraryStepOnBus source);

	@Mapping(target = "type", constant="subway")
	@Mapping(target = "travelDistance" , expression = "java(DistanceConverter.degreeToMeters(source.getTravelDistance()))")
	@Mapping(target = "busRoute" , ignore = true)
	ItineraryStepDTO stepOnSubwayToStep(ItineraryStepOnSubway source);

}
