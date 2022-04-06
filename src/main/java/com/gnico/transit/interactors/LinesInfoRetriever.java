package com.gnico.transit.interactors;

import org.springframework.stereotype.Component;

import com.gnico.transit.usecases.GetAllLines;
import com.gnico.transit.usecases.GetAllLinesResponse;

@Component
class LinesInfoRetriever implements GetAllLines {

	private BusDataGateway busDataGateway;
	private SubwayDataGateway subwayDataGateway;
	private TrainDataGateway trainDataGateway;
	
	public LinesInfoRetriever(BusDataGateway busDataGateway, SubwayDataGateway subwayDataGateway,
			TrainDataGateway trainDataGateway) {
		this.busDataGateway = busDataGateway;
		this.subwayDataGateway = subwayDataGateway;
		this.trainDataGateway = trainDataGateway;
	}
	
	@Override
	public GetAllLinesResponse getAllLines() {
		return new GetAllLinesResponse(busDataGateway.findAllBusLines(), 
				subwayDataGateway.findAllSubwayLines(), trainDataGateway.findAllTrainLines());
	}

	@Override
	public GetAllLinesResponse getLinesCloseTo(double lat, double lon) {
		double maxDistance = 0.01;
		return new GetAllLinesResponse(busDataGateway.findLinesCloseTo(lat, lon, maxDistance), 
				subwayDataGateway.findLinesCloseTo(lat, lon, maxDistance),
				trainDataGateway.findLinesCloseTo(lat, lon, maxDistance));
		
	}
	

}
