package com.rasyidcode.runnerz;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.rasyidcode.runnerz.user.User;
import com.rasyidcode.runnerz.user.UserHttpClient;
import com.rasyidcode.runnerz.user.UserRestClient;

@SpringBootApplication
public class RunnerzApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
	}

//    @Bean
//    CommandLineRunner runner(JdbcRunRepository runRepository) {
//		LocalDateTime now = LocalDateTime.now();
//		return args -> {
//			Run run = new Run(1, "First Run", now, now.plusMinutes(45), 5, Location.INDOOR);
//			runRepository.create(run);
//		};
//	}

//	@Bean
//	CommandLineRunner runner(UserRestClient client) {
//		return args -> {
////			User user = new User();
////			Address address = new Address();
////			System.out.println(address);
//			List<User> users = client.findAll();
////			users.stream().map(user -> user.getAddress()).forEach(System.out::println);
////			users.forEach(System.out::println);
//			System.out.println(users.size());
//
//			User user = client.findById(5);
//			System.out.println(user);
//		};
//	}

//	@Bean
//	CommandLineRunner runner2(UserHttpClient client) {
//		return args -> {
//			List<User> users = client.findAll();
//			System.out.println(users.size());
//
//			User user = client.findById(10);
//			System.out.println(user);
//		};
//	}

	@Bean
	UserHttpClient userHttpClient() {
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
				.build();
		return factory.createClient(UserHttpClient.class);
	}

}
