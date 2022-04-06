package com.gnico.transit.database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.gnico.transit.database.SubwayStopRepository;
import com.gnico.transit.database.entity.SubwayStopTableRow;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SubwayStopRepositoryTest {

	@Autowired
	SubwayStopRepository repository;
	
	@Test
	void test_getStopsForLine() {
		List<SubwayStopTableRow> stops =  repository.findAllByLine("D");
		assertEquals(16, stops.size());
		stops =  repository.findAllByLine("A");
		assertEquals(18, stops.size());
	}

}
