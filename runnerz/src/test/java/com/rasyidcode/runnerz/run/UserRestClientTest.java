package com.rasyidcode.runnerz.run;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rasyidcode.runnerz.user.Address;
import com.rasyidcode.runnerz.user.Company;
import com.rasyidcode.runnerz.user.Geo;
import com.rasyidcode.runnerz.user.User;
import com.rasyidcode.runnerz.user.UserRestClient;

@RestClientTest
@Import(UserRestClient.class)
public class UserRestClientTest {

	@Autowired
	MockRestServiceServer server;

	@Autowired
	UserRestClient client;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void shouldFindAllUsers() throws JsonProcessingException {
		User user = User.of(1, "Leanne Graham", "Bret", "Sincere@april.biz",
				Address.of("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874", Geo.of("-37.3159", "81.1496")),
				"1-770-736-8031 x56442", "hildegard.org",
				Company.of("Romaguera-Crona", "Multi-layered client-server neural-net", "harness real-time e-markets"));
		List<User> users = List.of(user);

		this.server.expect(requestTo("https://jsonplaceholder.typicode.com/users"))
				.andRespond(withSuccess(objectMapper.writeValueAsString(users), MediaType.APPLICATION_JSON));

		List<User> allUsers = client.findAll();
		assertEquals(users, allUsers);
	}

	@Test
	public void shouldFindUserById() throws JsonProcessingException {
		User user = User.of(1, "Leanne Graham", "Bret", "Sincere@april.biz",
				Address.of("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874", Geo.of("-37.3159", "81.1496")),
				"1-770-736-8031 x56442", "hildegard.org",
				Company.of("Romaguera-Crona", "Multi-layered client-server neural-net", "harness real-time e-markets"));

		this.server.expect(requestTo("https://jsonplaceholder.typicode.com/users/1"))
				.andRespond(withSuccess(objectMapper.writeValueAsString(user), MediaType.APPLICATION_JSON));

		User leanne = client.findById(1);
		assertEquals(user.getId(), 1);
		assertEquals(user.getName(), "Leanne Graham");
		assertAll("Address", () -> assertEquals(user.getAddress().getStreet(), "Kulas Light"),
				() -> assertEquals(user.getAddress().getGeo().getLat(), "-37.3159"),
				() -> assertEquals(user.getAddress().getGeo().getLng(), "81.1496"));
		assertAll("Company", () -> assertEquals(user.getCompany().getName(), "Romaguera-Crona"));
	}

}
