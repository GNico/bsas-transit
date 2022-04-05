package com.gnico.transit.database;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gnico.transit.database.entity.TrainRouteTableRow;
import com.gnico.transit.database.entity.TrainStopTableRow;
import com.gnico.transit.domain.TrainRoute;
import com.gnico.transit.domain.TrainStop;
import com.gnico.transit.interactors.TrainDataGateway;

@Component
public class TrainPersistenceAdapter implements TrainDataGateway {

	private TrainRouteRepository trainRouteRepository;
	private TrainStopRepository trainStopRepository;
	private DatabaseToDomainMapper databaseToDomainMapper;
	
	public TrainPersistenceAdapter(TrainRouteRepository trainRouteRepository, TrainStopRepository trainStopRepository,
			DatabaseToDomainMapper databaseToDomainMapper) {
		this.trainRouteRepository = trainRouteRepository;
		this.trainStopRepository = trainStopRepository;
		this.databaseToDomainMapper = databaseToDomainMapper;
	}

	@Override
	public List<String> findAllTrainLines() {
		return trainRouteRepository.findTrainLines();
	}
	
	@Override 
	public List<String> findLinesCloseTo(double lat, double lon, double distance) {
		return trainRouteRepository.findClosestLinesToLocation(lat, lon, distance);
	}
	
	@Override
	public List<TrainRoute> findRoutesForLine(String line) {
		List<TrainRouteTableRow> routes = trainRouteRepository.findByLine(line);
		fetchStops(routes);
		return databaseToDomainMapper.trainRouteTableToTrainEntityList(routes);
	}
	
	@Override
	public List<TrainStop> findStopsForLineAndBranch(String line, String branch) {
		List<TrainStopTableRow> stops = trainStopRepository.findAllByLineAndBranch(line, branch);
		return databaseToDomainMapper.trainStopTableToTrainStopEntityList(stops);
	} 
	
	private void fetchStops(TrainRouteTableRow route) {
		route.setStops(trainStopRepository.findAllByLineAndBranch(route.getLine(), route.getBranch()));
	}
	
	private void fetchStops(List<TrainRouteTableRow> routes) {
		for (TrainRouteTableRow route : routes) {
			fetchStops(route);
		}
	}

	
}
