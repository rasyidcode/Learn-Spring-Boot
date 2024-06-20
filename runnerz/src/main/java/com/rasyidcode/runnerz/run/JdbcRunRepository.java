package com.rasyidcode.runnerz.run;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class JdbcRunRepository {

	private static final Logger logger = LoggerFactory.getLogger(JdbcRunRepository.class);

	private JdbcClient jdbcClient;

	public JdbcRunRepository(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}
	
	public List<Run> findAll() {
		return jdbcClient.sql("SELECT * FROM run")
				.query(Run.class)
				.list();
	}

	public Optional<Run> findById(Integer id) {
		return jdbcClient.sql("SELECT id, title, started_on, completed_on, miles, location FROM run WHERE id = :id")
					.param("id", id)
					.query(Run.class)
					.optional();
	}
	
	public void create(Run run) {
		int updated = jdbcClient.sql("INSERT INTO run(id, title, started_on, completed_on, miles, location) VALUES(?, ?, ?, ?, ?, ?)")
				.params(List.of(run.getId(), run.getTitle(), run.getStartedOn(), run.getCompletedOn(), run.getMiles(), run.getLocation().toString()))
				.update();

		Assert.state(updated == 1, "Failed to create run " + run.getTitle());
	}

	public void update(Run run, Integer id) {
		int updated = jdbcClient.sql("UPDATE run SET title = ?, started_on = ?, completed_on = ?, miles = ?, location = ? WHERE id = ?")
				.params(List.of(run.getTitle(), run.getStartedOn(), run.getCompletedOn(), run.getMiles(), run.getLocation().toString(), id))
				.update();

		Assert.state(updated == 1, "Failed to update run " + run.getTitle());
	}

	public void delete(Integer id) {
		int updated = jdbcClient.sql("DELETE FROM run WHERE id = :id")
				.param("id", id)
				.update();

		Assert.state(updated == 1, "Failed to delete run with id " + id);
	}

	public int count() {
		return jdbcClient.sql("SELECT * FROM Run").query().listOfRows().size(); 
	}

	public void saveAll(List<Run> runs) {
		runs.stream().forEach(this::create);
	}

	public List<Run> findByLocation(String location) {
		return jdbcClient.sql("SELECT * FROM Run WHERE location = :location")
				.param("location", location)
				.query(Run.class)
				.list();
	}

}
