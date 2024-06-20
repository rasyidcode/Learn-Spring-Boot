package com.rasyidcode.runnerz.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Company {

	private String name;

	private String catchPhrase;

	private String bs;

}
