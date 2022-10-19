package com.utilities;

public class CheckoutDetails {
	String firstName;
	String lastName;
	String email;
	String mobile;
	String address1;
	String city;
	String state;
	String country;
	String postalCode;
	
	public CheckoutDetails(String firstName, String lastName, String email, String mobile, String address1, String city,
			String state, String country, String postalCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getMobile() {
		return mobile;
	}
	public String getAddress1() {
		return address1;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public String getPostalCode() {
		return postalCode;
	}

	
	

}
