package com.rasyidcode.runnerz.run;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

@JdbcTest
@Import(JdbcRunRepository.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JdbcRunRepositoryTest {

	@Autowired
	public JdbcRunRepository repository;

	@BeforeEach
	public void setUp() {
		LocalDateTime now = LocalDateTime.now();
		repository.create(new Run(1, "Monday Morning Run", now, now.plusMinutes(30), 3, Location.INDOOR, null));
		repository.create(new Run(2, "Wednesday Evening Run", now, now.plusHours(1), 6, Location.OUTDOOR, null));
	}

	@Test
	public void shouldFindAllRuns() {
		List<Run> runs = repository.findAll();
		assertEquals(2, runs.size(), "Should have returned 2 runs");
	}

	@Test
	public void shouldFindRunWithValidId() {
		Run run = repository.findById(1).get();
		assertEquals("Monday Morning Run", run.getTitle());
		assertEquals(3, run.getMiles());
	}

	@Test
	public void shouldNotFindRunWithInvalidId() {
		Optional<Run> run = repository.findById(3);
		assertTrue(run.isEmpty());
	}

	@Test
	public void shouldCreateNewRun() {
		LocalDateTime now = LocalDateTime.now();
		repository.create(new Run(3, "Thursday at Dawn Run", now, now.plusHours(1), 10, Location.OUTDOOR, null));
		List<Run> runs = repository.findAll();
		assertEquals(3, runs.size());
	}

	@Test
	public void shouldUpdateRun() {
		LocalDateTime now = LocalDateTime.now();
		repository.update(new Run(2, "Thursday at Night Run", now, now.plusHours(1), 5, Location.INDOOR, null), 2);
		Run run = repository.findById(2).get();
		assertEquals("Thursday at Night Run", run.getTitle());
		assertEquals(5, run.getMiles());
		assertEquals(Location.INDOOR, run.getLocation());
	}

	@Test
	public void shouldDeleteRun() {
		repository.delete(2);
		List<Run> runs = repository.findAll();
		assertEquals(1, runs.size());
	}

}
