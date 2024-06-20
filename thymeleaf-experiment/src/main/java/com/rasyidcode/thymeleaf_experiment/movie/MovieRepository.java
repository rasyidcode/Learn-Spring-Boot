package com.rasyidcode.thymeleaf_experiment.movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

	public List<Movie> findAll();

	public Optional<Movie> findById(long id);

	public void create(Movie movie);

	public void update(Movie movie);

	public void deleteById(long id);
}
