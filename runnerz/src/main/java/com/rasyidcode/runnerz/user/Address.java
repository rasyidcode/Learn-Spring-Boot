package com.rasyidcode.runnerz.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Address {

	private String street;

	private String suite;

	private String city;

	private String zipcode;

	private Geo geo;

}
