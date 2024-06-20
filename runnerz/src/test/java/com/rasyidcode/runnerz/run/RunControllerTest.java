package com.rasyidcode.runnerz.run;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RunController.class)
public class RunControllerTest {

	@Autowired
	public MockMvc mvc;

	@Autowired
	public ObjectMapper objectMapper;

	@MockBean
	public DataJdbcRunRepository repository;

	private final List<Run> runs = new ArrayList<>();

	@BeforeEach
	public void setUp() {
		LocalDateTime now = LocalDateTime.now();
		runs.add(new Run(1, "Monday Morning Run", now, now.plusMinutes(30), 3, Location.INDOOR, null));
	}

	@Test
	public void shouldFindAllRuns() throws Exception {
		when(repository.findAll()).thenReturn(runs);
		mvc.perform(MockMvcRequestBuilders.get("/api/runs")).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(runs.size())));
	}

	@Test
	public void shouldFindOneRun() throws Exception {
		Run run = runs.get(0);
		when(repository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(run));
		mvc.perform(get("/api/runs/1")).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(run.getId())))
				.andExpect(jsonPath("$.title", is(run.getTitle()))).andExpect(jsonPath("$.miles", is(run.getMiles())))
				.andExpect(jsonPath("$.location", is(run.getLocation().toString())));
	}

	@Test
	public void shouldReturnNotFoundWithInvalidId() throws Exception {
		mvc.perform(get("/api/runs/99")).andExpect(status().isNotFound());
	}

	@Test
	public void shouldCreateNewRun() throws Exception {
		LocalDateTime now = LocalDateTime.now();
		Run run = new Run(2, "Wednesday Evening Run", now, now.plusHours(1), 6, Location.OUTDOOR, null);
		mvc.perform(
				post("/api/runs").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(run)))
				.andExpect(status().isCreated());

	}

	@Test
	public void shouldUpdateRun() throws Exception {
		when(repository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(runs.get(0)));
		LocalDateTime now = LocalDateTime.now();
		Run run = new Run(2, "Saturday Night Run", now, now.plusHours(2), 20, Location.INDOOR, null);
		mvc.perform(put("/api/runs/1").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(run))).andExpect(status().isNoContent());
	}

	@Test
	public void shouldDeleteRun() throws Exception {
		mvc.perform(delete("/api/runs/1"))
			.andExpect(status().isNoContent());
	}

}
