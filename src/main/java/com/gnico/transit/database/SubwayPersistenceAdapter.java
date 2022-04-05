package com.gnico.transit.database;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gnico.transit.database.entity.SubwayRouteTableRow;
import com.gnico.transit.domain.SubwayRoute;
import com.gnico.transit.interactors.SubwayDataGateway;

@Component
public class SubwayPersistenceAdapter implements SubwayDataGateway {

	private SubwayRouteRepository subwayRouteRepository;
	private SubwayStopRepository subwayStopRepository;
	private DatabaseToDomainMapper databaseToDomainMapper;
	
	public SubwayPersistenceAdapter(SubwayRouteRepository subwayRouteRepository,
			SubwayStopRepository subwayStopRepository, DatabaseToDomainMapper databaseToDomainMapper) {
		this.subwayRouteRepository = subwayRouteRepository;
		this.subwayStopRepository = subwayStopRepository;
		this.databaseToDomainMapper = databaseToDomainMapper;
	}

	@Override
	public List<String> findAllSubwayLines() {
		return subwayRouteRepository.findSubwayLines();
	}
	
	@Override 
	public List<String> findLinesCloseTo(double lat, double lon, double distance) {
		return subwayRouteRepository.findClosestLinesToLocation(lat, lon, distance);
	}

	@Override
	public SubwayRoute findRouteForLine(String line) {
		SubwayRouteTableRow route = subwayRouteRepository.findByLine(line);
		fetchStops(route);
		return databaseToDomainMapper.subwayRouteTableToSubwayEntity(route);
	}
	
	@Override
	public List<SubwayRoute> findRoutesCloseToLocation(double lat, double lon, double maxDistance) {
		List<SubwayRouteTableRow> routes = subwayRouteRepository.findClosestRoutesToLocation(lat, lon, maxDistance);
		fetchStops(routes);
		return databaseToDomainMapper.subwayRouteTableToSubwayEntityList(routes);
	}
	
	
	private void fetchStops(SubwayRouteTableRow route) {
		route.setStops(subwayStopRepository.findAllByLine(route.getLine()));
	}
	
	private void fetchStops(List<SubwayRouteTableRow> routes) {
		for (SubwayRouteTableRow route : routes) {
			fetchStops(route);
		}
	}
	
}
