package com.gnico.transit.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gnico.transit.database.entity.TrainRouteTableRow;

public interface TrainRouteRepository extends JpaRepository<TrainRouteTableRow, Integer> {

	@Query(value="select linea from (select distinct linea from train_routes) "
			+ "tr order by length(tr.linea), tr.linea", nativeQuery = true)
	List<String> findTrainLines();

	List<TrainRouteTableRow> findByLine(String line);

	@Query(value="select distinct linea from train_routes as r "
			+ "where ST_DWithin(ST_SetSRID(ST_MakePoint( :lon, :lat), 4326), r.route_geom, :distance )"
			, nativeQuery=true)
	List<String> findClosestLinesToLocation(@Param("lat") double lat, @Param("lon") double lon,
			@Param("distance") double distance);
	

}
