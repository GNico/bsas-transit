package com.gnico.transit.database;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gnico.transit.database.entity.BusRouteTableRow;
import com.gnico.transit.database.entity.BusStopTableRow;
import com.gnico.transit.domain.BusRoute;
import com.gnico.transit.domain.BusStop;
import com.gnico.transit.interactors.BusDataGateway;

@Component
public class BusPersistenceAdapter implements BusDataGateway {
	
	private BusRouteRepository busRouteRepository;
	private BusStopRepository busStopRepository;
	private DatabaseToDomainMapper databaseToDomainMapper;
	
	public BusPersistenceAdapter(BusRouteRepository busRouteRepository,
			BusStopRepository busStopRepository, DatabaseToDomainMapper databaseToDomainMapper) {
		this.busRouteRepository = busRouteRepository;
		this.busStopRepository = busStopRepository;
		this.databaseToDomainMapper = databaseToDomainMapper;
	}

	@Override
	public List<String> findAllBusLines() {
		return busRouteRepository.findBusLines();
	}
	
	@Override 
	public List<String> findLinesCloseTo(double lat, double lon, double distance) {
		return busRouteRepository.findClosestLinesToLocation(lat, lon, distance);
	}
	
	@Override
	public List<BusRoute> findRoutesForLine(String linea) {	
		List<BusRouteTableRow> routes = busRouteRepository.findByLinea(linea);		
		return databaseToDomainMapper.busRouteTableToBusRouteEntityList(routes);
	}
	
	
	public List<BusStop> findStopsForRouteAndDirection(int routeId, boolean returnDirection) {
		List<BusStopTableRow> stops = busStopRepository.findAllByRouteIdAndDirection(
				routeId, (short) (returnDirection ? 1 : 0));
		return databaseToDomainMapper.busStopTableToBusStopEntityList(stops);
	}

	@Override
	public List<BusRoute> findRoutesCloseToLocation(double lat, double lon, double maxDistance) {
		List<BusRouteTableRow> routes = busRouteRepository.findClosestRoutesToLocation(lat, lon, maxDistance);
		return databaseToDomainMapper.busRouteTableToBusRouteEntityList(routes);
	}

}
