package com.rasyidcode.quoters;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {

	@Bean
	CommandLineRunner init(QuoteRepository quoteRepository) {
		return args -> {
			quoteRepository
					.save(new Quote("Working with Spring Boot is like pair-programming with the Spring developers."));
			quoteRepository.save(new Quote("With Boot you deploy everywhere you can find a JVM basically."));
			quoteRepository.save(new Quote("Spring has come quite a ways in addressing developer enjoyment and ease of "
					+ "use since the last time I built an application using it."));
			quoteRepository.save(new Quote("Previous to Spring Boot, I remember XML hell, confusing setup and many "
					+ "of hours frustation."));
			quoteRepository.save(new Quote("Spring Boot solves this problem. It get rids of XML and wires up common "
					+ "components for me, so I don't have spend hours scratching my head just to figure out how it's all pieced together."));
			quoteRepository
					.save(new Quote("It embraces convention over configuration, providing experience on par with "
							+ "frameworks that excel at early stage of development, such as Ruby on Rails."));
			quoteRepository.save(new Quote("The real benefit of Boot, however, is that it's just Spring. That "
					+ "means any direction code takes, regardless of complexity, I know it's a safe bet."));
			quoteRepository.save(new Quote("I don't worry about my code scaling. Boot allows the developer to peel back "
					+ "the layers and customize when it's appropriate while keeping the convetions that just work."));
			quoteRepository.save(new Quote("So easy it is to switch container in #springboot"));
			quoteRepository.save(new Quote("Really loving Spring Boot, makes stand alone Spring apps easy."));
			quoteRepository.save(new Quote("I have two hours today to build an app from scratch. @springboot to the rescue!"));
			quoteRepository.save(new Quote("@springboot with @springframework is pure productivity! Who said in #java one has to write "
					+ "double the code than in other langs? #newFavLib"));
		};
	}

}
