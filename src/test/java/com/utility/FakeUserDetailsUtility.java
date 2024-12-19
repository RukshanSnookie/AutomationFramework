package com.utility;

import com.github.javafaker.Faker;
import com.ui.pojo.EditUserDataPOJO;

public class FakeUserDetailsUtility {

	public static void main(String[] args) {
		getFakeUserData();
	}

	public static EditUserDataPOJO getFakeUserData() {

		Faker faker = new Faker();

		EditUserDataPOJO editUserDataPojo = new EditUserDataPOJO(faker.name().firstName(), faker.name().lastName(),
				"password");

		return editUserDataPojo;
	}
}
