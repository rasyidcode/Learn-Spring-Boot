package com.rasyidcode.runnerz.run;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InMemoryRunRepositoryTest {

	public InMemoryRunRepository repository;

	@BeforeEach
	public void setUp() {
		repository = new InMemoryRunRepository();
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
		RunNotFoundException notFoundException = assertThrows(RunNotFoundException.class,
				() -> repository.findById(3).get());
		assertEquals("Run not found!", notFoundException.getMessage());
	}

	@Test
	public void shouldCreateNewRun() {
		LocalDateTime now = LocalDateTime.now();
		repository.create(new Run(2, "Thursday at Dawn Run", now, now.plusHours(1), 10, Location.OUTDOOR, null));
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
