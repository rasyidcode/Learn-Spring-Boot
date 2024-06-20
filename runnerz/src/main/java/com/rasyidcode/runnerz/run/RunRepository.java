package com.rasyidcode.runnerz.run;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {

	private List<Run> runs = new ArrayList<>();

	public List<Run> findAll() {
		return runs;
	}

	public Optional<Run> findById(Integer id) {
		return runs.stream()
				.filter(run -> run.getId() == id)
				.findFirst();
	}

	public void create(Run run) {
		runs.add(run);
	}

	public void update(Run run, Integer id) {
		Optional<Run> existingRun = findById(id);
		if (existingRun.isPresent()) {
			runs.set(runs.indexOf(existingRun.get()), run);
		}
	}

	public void delete(Integer id) {
		runs.removeIf(run -> run.getId().equals(id));
	}

	@PostConstruct
	private void init() {
		LocalDateTime now = LocalDateTime.now();
		runs.add(new Run(1, "Monday Morning Run", now, now.plusMinutes(30), 3, Location.INDOOR, 1));
		runs.add(new Run(2, "Wednesday Evening Run", now, now.plusHours(1), 6, Location.OUTDOOR, 1));
	}

}
