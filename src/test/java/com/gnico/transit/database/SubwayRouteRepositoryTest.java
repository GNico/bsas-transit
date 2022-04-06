package com.gnico.transit.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.gnico.transit.database.SubwayRouteRepository;
import com.gnico.transit.database.entity.SubwayRouteTableRow;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SubwayRouteRepositoryTest {

	@Autowired
	SubwayRouteRepository repository;
	
		
	@Test
	void test_getAllSubwayLines() {
		List<String> expectedLines = List.of("A", "B", "C", "D", "E", "H");
		List<String> lines = repository.findSubwayLines();
		assertEquals(expectedLines.size(), lines.size());
		for (int i = 0; i < expectedLines.size(); i++) {
			assertEquals(expectedLines.get(i), lines.get(i));
		}
	}
	
	@Test
	void test_getSubwayLine() {
		SubwayRouteTableRow row = repository.findByLine("D");
		assertEquals("D", row.getLine());
		assertNull(row.getStops()); //stops not fetched because transient
	}

}
