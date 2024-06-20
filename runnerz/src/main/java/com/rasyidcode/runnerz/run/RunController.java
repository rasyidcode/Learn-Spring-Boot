package com.rasyidcode.runnerz.run;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/runs")
public class RunController {

//	private final RunRepository runRepository;
//	private final JdbcRunRepository runRepository;
	private final DataJdbcRunRepository runRepository;

//	public RunController(RunRepository runRepository) {
//		this.runRepository = runRepository;
//	}

	public RunController(DataJdbcRunRepository runRepository) {
		this.runRepository = runRepository;
	}

	@GetMapping("")
	public List<Run> findAll() {
		return runRepository.findAll();
	}

	@GetMapping("/{id}")
	public Run findById(@PathVariable("id") Integer id) {
		Optional<Run> run = runRepository.findById(id);
		if (run.isEmpty()) {
			throw new RunNotFoundException();
		}

		return run.get();
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@Valid @RequestBody Run run) {
//		runRepository.create(run);
		runRepository.save(run);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@Valid @RequestBody Run runReqBody, @PathVariable("id") Integer id) {
//		runRepository.update(run, id);
		Optional<Run> existingRun = runRepository.findById(id);
		if (!existingRun.isPresent()) {
			throw new RunNotFoundException();
		}

		Run run = existingRun.get();
		run.setTitle(runReqBody.getTitle());
		run.setStartedOn(runReqBody.getStartedOn());
		run.setCompletedOn(runReqBody.getCompletedOn());
		run.setMiles(runReqBody.getMiles());
		run.setLocation(runReqBody.getLocation());
		runRepository.save(run);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
//		runRepository.delete(id);
		runRepository.deleteById(id);
	}

	@GetMapping("/location/{location}")
	public List<Run> findByLocation(@PathVariable("location") String location) {
		return runRepository.findAllByLocation(location);
	}


	@GetMapping("/miles/{miles}")
	public Run findByMiles(@PathVariable("miles") Integer miles) {
		return runRepository.findByMiles(miles);
	}
}
