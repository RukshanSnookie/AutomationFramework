package com.ui.pojo;

public class EditUserDataPOJO {

	private String firstName;
	private String lastName;
	private String oldPassword;

	public EditUserDataPOJO(String firstName, String lastName, String oldPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.oldPassword = oldPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	@Override
	public String toString() {
		return "EditUserDataPOJO [firstName=" + firstName + ", lastName=" + lastName + ", oldPassword=" + oldPassword
				+ "]";
	}

}
