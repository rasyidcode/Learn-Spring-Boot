package com.rasyidcode.runnerz.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class User {

	private Integer id;

	private String name;

	private String username;

	private String email;

	private Address address;

	private String phone;

	private String website;

	private Company company;

}
