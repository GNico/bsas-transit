package com.gnico.transit.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gnico.transit.database.entity.SubwayStopTableRow;

public interface SubwayStopRepository extends JpaRepository<SubwayStopTableRow, Integer> {

	List<SubwayStopTableRow> findAllByLine(String line);

}
