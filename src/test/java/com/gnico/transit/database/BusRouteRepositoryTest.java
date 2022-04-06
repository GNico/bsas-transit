package com.gnico.transit.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.gnico.transit.database.BusRouteRepository;
import com.gnico.transit.database.entity.BusRouteTableRow;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql("/insertBusRoutes.sql")
class BusRouteRepositoryTest {
	
	/* test data set contains the following routes:
	 * line 93 - A 
	 * line 93 - C
	 * line 41 - A
	 * line 161 - A
	 * line 161 - B
	 * (10 total routes adding the opposite direction routes)
	 */

	@Autowired
	BusRouteRepository repository;
		
	@Test
	void test_getAllBusLinestest() {
		List<String> expectedLines = List.of("41", "93", "161");
		List<String> lines = repository.findBusLines();
		assertEquals(expectedLines.size(), lines.size());
		for (int i = 0; i < expectedLines.size(); i++) {
			assertEquals(expectedLines.get(i), lines.get(i));
		}
	}
	
	@Test
	void test_findRoutesCloseToLocation() {
		List<String> expected = List.of("41A", "93A");
		List<BusRouteTableRow> result = repository.findClosestRoutesToLocation(-34.5425757, -58.5078290, 0.004);
		assertEquals(4, result.size());  //2 direction for each route
		for (BusRouteTableRow line : result) {
			assertTrue(expected.contains(line.getShortName()));
		}
	} 
	
	
	

}
