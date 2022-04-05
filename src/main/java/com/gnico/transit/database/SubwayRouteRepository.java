package com.gnico.transit.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gnico.transit.database.entity.SubwayRouteTableRow;

@Repository
public interface SubwayRouteRepository extends JpaRepository<SubwayRouteTableRow, Integer>  {
	
	@Query(value="select linea from (select distinct linea from subway_routes) "
			+ "sr order by length(sr.linea), sr.linea", nativeQuery = true)
	List<String> findSubwayLines();
	
	SubwayRouteTableRow findByLine(String line);

	@Query(value="select * from subway_routes as r "
			+ "where ST_DWithin(ST_SetSRID(ST_MakePoint( :lon, :lat), 4326), r.route_geom, :distance )"
			, nativeQuery=true)
	List<SubwayRouteTableRow> findClosestRoutesToLocation(@Param("lat") double lat, @Param("lon") double lon,
			@Param("distance") double distance);

	@Query(value="select distinct linea from subway_routes as r "
			+ "where ST_DWithin(ST_SetSRID(ST_MakePoint( :lon, :lat), 4326), r.route_geom, :distance )"
			, nativeQuery=true)
	List<String> findClosestLinesToLocation(@Param("lat") double lat, @Param("lon") double lon,
			@Param("distance") double distance);
	
	
}
