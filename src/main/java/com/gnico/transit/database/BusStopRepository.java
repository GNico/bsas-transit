package com.gnico.transit.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gnico.transit.database.entity.BusStopTableRow;

@Repository
public interface BusStopRepository extends JpaRepository<BusStopTableRow, Integer> {

	List<BusStopTableRow> findAllByRouteIdAndDirection(Integer routeId, Short direction);
	
}
