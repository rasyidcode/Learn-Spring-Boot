package com.rasyidcode.runnerz.run;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class InMemoryRunRepository {

	private static final Logger logger = LoggerFactory.getLogger(InMemoryRunRepository.class);
	private final List<Run> runs = new ArrayList<>();

	public List<Run> findAll() {
		return runs;
	}

	public Optional<Run> findById(Integer id) {
		return Optional.ofNullable(
				runs.stream().filter(run -> run.getId() == id).findFirst().orElseThrow(RunNotFoundException::new));
	}

	public void create(Run run) {
		Run newRun = new Run(run.getId(), run.getTitle(), run.getStartedOn(), run.getCompletedOn(), run.getMiles(),
				run.getLocation(), null);
		runs.add(newRun);
	}

	public void update(Run newRun, Integer id) {
		Optional<Run> existingRun = findById(id);
		if (existingRun.isPresent()) {
			Run r = existingRun.get();
			logger.info("Update Existing Run: " + existingRun.get());
			runs.set(runs.indexOf(r), newRun);
		}
	}

	public void delete(Integer id) {
		logger.info("Delete Run: " + id);
		runs.removeIf(run -> run.getId().equals(id));
	}

	public int count() {
		return runs.size();
	}

	public void saveAll(List<Run> newRuns) {
		newRuns.stream().forEach(run -> create(run));
	}

	public List<Run> findByLocation(String location) {
		return runs.stream()
				.filter(run -> Objects.equals(run.getLocation(), location))
				.toList();
	}

	@PostConstruct
	private void init() {
		LocalDateTime now = LocalDateTime.now();
		runs.add(new Run(1, "Monday Morning Run", now, now.plusMinutes(30), 3, Location.INDOOR, null));
		runs.add(new Run(2, "Wednesday Evening Run", now, now.plusHours(1), 6, Location.OUTDOOR, null));
	}

}
