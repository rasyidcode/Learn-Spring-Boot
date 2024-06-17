package com.rasyidcode.quoters;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

	private final static Quote NONE = new Quote("None");
	private final static Random RANDOMIZER = new Random();

	private final QuoteRepository quoteRepository;

	public QuoteController(QuoteRepository quoteRepository) {
		this.quoteRepository = quoteRepository;
	}

	@GetMapping("/api")
	public List<QuoteResource> getAll() {
		return quoteRepository.findAll().stream().map(quote -> new QuoteResource("success", quote))
				.collect(Collectors.toList());
	}

	@GetMapping("/api/{id}")
	public QuoteResource getOne(@PathVariable("id") Long id) {
		return quoteRepository.findById(id).map(quote -> new QuoteResource("success", quote))
				.orElse(new QuoteResource("Quote " + id + " does not exist", NONE));
	}

	@GetMapping("/api/random")
	public QuoteResource getRandomOne() {
		return getOne(nextLong(1, quoteRepository.count() + 1));
	}

	private long nextLong(long lowerRange, long upperRange) {
		return (int) (RANDOMIZER.nextDouble() * (upperRange - lowerRange)) + lowerRange;
	}

}
