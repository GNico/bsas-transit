package com.gnico.transit.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gnico.transit.database.entity.TrainStopTableRow;

interface TrainStopRepository extends JpaRepository<TrainStopTableRow, Integer> {

	List<TrainStopTableRow> findAllByLine(String line);

	List<TrainStopTableRow> findAllByLineAndBranch(String line, String branch);

}
