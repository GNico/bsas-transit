package com.gnico.transit.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gnico.transit.database.entity.BusRouteTableRow;

@Repository
interface BusRouteRepository extends JpaRepository<BusRouteTableRow, Integer> {
			
	@Query(value="select linea from (select distinct linea from bus_routes) "
			+ "br order by length(br.linea), br.linea", nativeQuery = true)
	List<String> findBusLines();

	List<BusRouteTableRow> findByLinea(String line);
	
	@Query(value="select * from bus_routes as r "
			+ "where ST_DWithin(ST_SetSRID(ST_MakePoint( :lon, :lat), 4326), r.route_geom, :distance )"
			, nativeQuery=true)
	List<BusRouteTableRow> findClosestRoutesToLocation(@Param("lat") double lat, @Param("lon") double lon,
			@Param("distance") double distance);
	
	@Query(value="select distinct linea from bus_routes as r "
			+ "where ST_DWithin(ST_SetSRID(ST_MakePoint( :lon, :lat), 4326), r.route_geom, :distance )"
			, nativeQuery=true)
	List<String> findClosestLinesToLocation(@Param("lat") double lat, @Param("lon") double lon,
			@Param("distance") double distance);

}