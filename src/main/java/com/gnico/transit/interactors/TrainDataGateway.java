package com.gnico.transit.interactors;

import java.util.List;

import com.gnico.transit.domain.TrainRoute;
import com.gnico.transit.domain.TrainStop;

public interface TrainDataGateway {

	List<String> findAllTrainLines();
	
	List<String> findLinesCloseTo(double lat, double lon, double distance);

	List<TrainRoute> findRoutesForLine(String line);

	List<TrainStop> findStopsForLineAndBranch(String line, String branch);

}
