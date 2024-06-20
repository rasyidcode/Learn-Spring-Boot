package com.rasyidcode.runnerz.run;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface DataJdbcRunRepository extends ListCrudRepository<Run, Integer> {

	public List<Run> findAllByLocation(String location); 

	@Query("SELECT * FROM run WHERE miles = :miles LIMIT 1")
	public Run findByMiles(@Param("miles") Integer miles);
}
